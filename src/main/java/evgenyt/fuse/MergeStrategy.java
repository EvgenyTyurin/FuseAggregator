package evgenyt.fuse;

import org.apache.camel.Exchange;

/**
 *	Merge strategy for aggregator 
 */

public class MergeStrategy implements 
	org.apache.camel.processor.aggregate.AggregationStrategy {

	// Simple file1 + file2 aggregation
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null)
			return newExchange;
		oldExchange.getIn().setBody(oldExchange.getIn().getBody(String.class) + 
				newExchange.getIn().getBody(String.class));
		return oldExchange; 
	}

}
