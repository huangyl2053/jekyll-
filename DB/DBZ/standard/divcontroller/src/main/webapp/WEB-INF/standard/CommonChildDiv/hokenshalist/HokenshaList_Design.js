var DBZ;
(function (DBZ) {
    (function (HokenshaList) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlHokenshaList = function () {
                return "onChange_ddlHokenshaList";
            };
            return Events;
        })();
        HokenshaList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HokenshaList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HokenshaList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HokenshaList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HokenshaList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlHokenshaList = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaList"));
            };
            return Controls;
        })();
        HokenshaList.Controls = Controls;
    })(DBZ.HokenshaList || (DBZ.HokenshaList = {}));
    var HokenshaList = DBZ.HokenshaList;
})(DBZ || (DBZ = {}));
