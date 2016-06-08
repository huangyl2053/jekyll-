var DBZ;
(function (DBZ) {
    (function (ShisetsuInputGuide) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShisetsuInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShisetsuNyutaishoRirekikanri = function () {
                return new DBZ.ShisetsuNyutaishoRirekiKanri.ModeController(this.convFiledName("ccdShisetsuNyutaishoRirekikanri"));
            };

            Controls.prototype.linizontalLine = function () {
                return new UZA.HorizontalLine(this.convFiledName("linizontalLine"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        ShisetsuInputGuide.Controls = Controls;
    })(DBZ.ShisetsuInputGuide || (DBZ.ShisetsuInputGuide = {}));
    var ShisetsuInputGuide = DBZ.ShisetsuInputGuide;
})(DBZ || (DBZ = {}));
