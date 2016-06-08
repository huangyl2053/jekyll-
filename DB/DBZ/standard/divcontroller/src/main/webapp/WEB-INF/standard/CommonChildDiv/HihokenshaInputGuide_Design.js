var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        HihokenshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblSearchResultOfHihokensha = function () {
                return new UZA.Label(this.convFiledName("lblSearchResultOfHihokensha"));
            };

            Controls.prototype.dgSearchResultOfHihokensha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOfHihokensha"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        HihokenshaInputGuide.Controls = Controls;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));
