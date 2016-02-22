var DBA;
(function (DBA) {
    (function (ShisetsuJohoCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuJohoCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuJohoCommonChildDiv.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.台帳種別表示有りモード = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = false;
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
                };
                State.prototype.台帳種別表示無しモード = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
                };
                State.prototype.被保険者モード = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                State.prototype.他市町村住所地特例者モード = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                State.prototype.適用除外者モード = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().displayNone = true;
                    this.controls.radOtherTokureiShisetsu().displayNone = true;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                return State;
            })();
            Modes.State = State;
        })(ShisetsuJohoCommonChildDiv.Modes || (ShisetsuJohoCommonChildDiv.Modes = {}));
        var Modes = ShisetsuJohoCommonChildDiv.Modes;
    })(DBA.ShisetsuJohoCommonChildDiv || (DBA.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBA.ShisetsuJohoCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShisetsuJohoCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuJohoCommonChildDiv.PublicProperties = PublicProperties;
    })(DBA.ShisetsuJohoCommonChildDiv || (DBA.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBA.ShisetsuJohoCommonChildDiv;
})(DBA || (DBA = {}));
