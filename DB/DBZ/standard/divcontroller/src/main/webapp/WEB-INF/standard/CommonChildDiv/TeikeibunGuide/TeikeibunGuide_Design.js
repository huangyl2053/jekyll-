var DBZ;
(function (DBZ) {
    (function (TeikeibunGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectTeikeibun = function () {
                return "onSelectTeikeibun";
            };

            Events.onClickModoru = function () {
                return "onClickModoru";
            };
            return Events;
        })();
        TeikeibunGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TeikeibunGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.TeikeibunGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.TeikeibunGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TeikeibunGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTeikeibunZokusei = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTeikeibunZokusei"));
            };

            Controls.prototype.dgTeikeibunIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgTeikeibunIchiran"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        TeikeibunGuide.Controls = Controls;
    })(DBZ.TeikeibunGuide || (DBZ.TeikeibunGuide = {}));
    var TeikeibunGuide = DBZ.TeikeibunGuide;
})(DBZ || (DBZ = {}));
