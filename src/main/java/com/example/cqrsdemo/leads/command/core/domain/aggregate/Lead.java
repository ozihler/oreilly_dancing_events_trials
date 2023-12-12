package com.example.cqrsdemo.leads.command.core.domain.aggregate;

import com.example.cqrsdemo.leads.command.core.domain.value.ChangeSetId;
import com.example.cqrsdemo.leads.command.core.domain.value.ChangeSet;
import com.example.cqrsdemo.leads.command.core.domain.value.LeadId;
import com.example.cqrsdemo.leads.command.core.domain.value.MetaData;

public class Lead {
    private LeadId leadId;
    private ChangeSetId changeSetId;
    private ChangeSet payLoad;
    private MetaData metaData;

    public Lead(LeadId leadId, ChangeSetId changeSetId, ChangeSet payLoad, MetaData metaData) {
        this.leadId = leadId;
        this.changeSetId = changeSetId;
        this.payLoad = payLoad;
        this.metaData = metaData;
    }

    public LeadId getLeadId() {
        return leadId;
    }

    public ChangeSetId getChangeSetId() {
        return changeSetId;
    }

    public ChangeSet getPayLoad() {
        return payLoad;
    }

    public MetaData getMetaData() {
        return metaData;
    }
}
