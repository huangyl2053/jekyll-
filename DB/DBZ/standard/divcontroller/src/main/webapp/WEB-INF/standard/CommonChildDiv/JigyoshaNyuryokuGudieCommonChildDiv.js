var DBZ;
(function (DBZ) {
    (function (JigyoshaNyuryokuGudieCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaNyuryokuGudieCommonChildDiv.Controls(fieldName);
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
                return new JigyoshaNyuryokuGudieCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaNyuryokuGudieCommonChildDiv.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.ServiceJigyoshaMode = function () {
                    this.controls.ServiceJigyosha().displayNone = false;
                    this.controls.OtherTokureiShisetsu().displayNone = true;
                };

                State.prototype.OtherTokureiShisetsuMode = function () {
                    this.controls.ServiceJigyosha().displayNone = true;
                    this.controls.OtherTokureiShisetsu().displayNone = false;
                };
                State.prototype.ShitekiJogaiShisetsuMode = function () {
                    this.controls.ServiceJigyosha().displayNone = true;
                    this.controls.OtherTokureiShisetsu().displayNone = true;
                };
                return State;
            })();
            Modes.State = State;
        })(JigyoshaNyuryokuGudieCommonChildDiv.Modes || (JigyoshaNyuryokuGudieCommonChildDiv.Modes = {}));
        var Modes = JigyoshaNyuryokuGudieCommonChildDiv.Modes;
    })(DBZ.JigyoshaNyuryokuGudieCommonChildDiv || (DBZ.JigyoshaNyuryokuGudieCommonChildDiv = {}));
    var JigyoshaNyuryokuGudieCommonChildDiv = DBZ.JigyoshaNyuryokuGudieCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JigyoshaNyuryokuGudieCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaNyuryokuGudieCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaNyuryokuGudieCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.JigyoshaNyuryokuGudieCommonChildDiv || (DBZ.JigyoshaNyuryokuGudieCommonChildDiv = {}));
    var JigyoshaNyuryokuGudieCommonChildDiv = DBZ.JigyoshaNyuryokuGudieCommonChildDiv;
})(DBZ || (DBZ = {}));
