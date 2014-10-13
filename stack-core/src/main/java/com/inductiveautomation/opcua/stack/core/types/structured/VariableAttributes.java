package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.types.builtin.LocalizedText;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.builtin.Variant;

public class VariableAttributes extends NodeAttributes {

    public static final NodeId TypeId = Identifiers.VariableAttributes;
    public static final NodeId BinaryEncodingId = Identifiers.VariableAttributes_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.VariableAttributes_Encoding_DefaultXml;

    protected final Variant _value;
    protected final NodeId _dataType;
    protected final Integer _valueRank;
    protected final Long[] _arrayDimensions;
    protected final Short _accessLevel;
    protected final Short _userAccessLevel;
    protected final Double _minimumSamplingInterval;
    protected final Boolean _historizing;

    public VariableAttributes(Long _specifiedAttributes, LocalizedText _displayName, LocalizedText _description, Long _writeMask, Long _userWriteMask, Variant _value, NodeId _dataType, Integer _valueRank, Long[] _arrayDimensions, Short _accessLevel, Short _userAccessLevel, Double _minimumSamplingInterval, Boolean _historizing) {
        super(_specifiedAttributes, _displayName, _description, _writeMask, _userWriteMask);
        this._value = _value;
        this._dataType = _dataType;
        this._valueRank = _valueRank;
        this._arrayDimensions = _arrayDimensions;
        this._accessLevel = _accessLevel;
        this._userAccessLevel = _userAccessLevel;
        this._minimumSamplingInterval = _minimumSamplingInterval;
        this._historizing = _historizing;
    }

    public Variant getValue() { return _value; }

    public NodeId getDataType() { return _dataType; }

    public Integer getValueRank() { return _valueRank; }

    public Long[] getArrayDimensions() { return _arrayDimensions; }

    public Short getAccessLevel() { return _accessLevel; }

    public Short getUserAccessLevel() { return _userAccessLevel; }

    public Double getMinimumSamplingInterval() { return _minimumSamplingInterval; }

    public Boolean getHistorizing() { return _historizing; }

    @Override
    public NodeId getTypeId() { return TypeId; }

    @Override
    public NodeId getBinaryEncodingId() { return BinaryEncodingId; }

    @Override
    public NodeId getXmlEncodingId() { return XmlEncodingId; }


    public static void encode(VariableAttributes variableAttributes, UaEncoder encoder) {
        encoder.encodeUInt32("SpecifiedAttributes", variableAttributes._specifiedAttributes);
        encoder.encodeLocalizedText("DisplayName", variableAttributes._displayName);
        encoder.encodeLocalizedText("Description", variableAttributes._description);
        encoder.encodeUInt32("WriteMask", variableAttributes._writeMask);
        encoder.encodeUInt32("UserWriteMask", variableAttributes._userWriteMask);
        encoder.encodeVariant("Value", variableAttributes._value);
        encoder.encodeNodeId("DataType", variableAttributes._dataType);
        encoder.encodeInt32("ValueRank", variableAttributes._valueRank);
        encoder.encodeArray("ArrayDimensions", variableAttributes._arrayDimensions, encoder::encodeUInt32);
        encoder.encodeByte("AccessLevel", variableAttributes._accessLevel);
        encoder.encodeByte("UserAccessLevel", variableAttributes._userAccessLevel);
        encoder.encodeDouble("MinimumSamplingInterval", variableAttributes._minimumSamplingInterval);
        encoder.encodeBoolean("Historizing", variableAttributes._historizing);
    }

    public static VariableAttributes decode(UaDecoder decoder) {
        Long _specifiedAttributes = decoder.decodeUInt32("SpecifiedAttributes");
        LocalizedText _displayName = decoder.decodeLocalizedText("DisplayName");
        LocalizedText _description = decoder.decodeLocalizedText("Description");
        Long _writeMask = decoder.decodeUInt32("WriteMask");
        Long _userWriteMask = decoder.decodeUInt32("UserWriteMask");
        Variant _value = decoder.decodeVariant("Value");
        NodeId _dataType = decoder.decodeNodeId("DataType");
        Integer _valueRank = decoder.decodeInt32("ValueRank");
        Long[] _arrayDimensions = decoder.decodeArray("ArrayDimensions", decoder::decodeUInt32, Long.class);
        Short _accessLevel = decoder.decodeByte("AccessLevel");
        Short _userAccessLevel = decoder.decodeByte("UserAccessLevel");
        Double _minimumSamplingInterval = decoder.decodeDouble("MinimumSamplingInterval");
        Boolean _historizing = decoder.decodeBoolean("Historizing");

        return new VariableAttributes(_specifiedAttributes, _displayName, _description, _writeMask, _userWriteMask, _value, _dataType, _valueRank, _arrayDimensions, _accessLevel, _userAccessLevel, _minimumSamplingInterval, _historizing);
    }

    static {
        DelegateRegistry.registerEncoder(VariableAttributes::encode, VariableAttributes.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(VariableAttributes::decode, VariableAttributes.class, BinaryEncodingId, XmlEncodingId);
    }

}