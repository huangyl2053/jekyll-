var DBZ;
(function (DBZ) {
    (function (YokaigodoGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_Yokaigodo = function () {
                return "onSelect_Yokaigodo";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };
            return Events;
        })();
        YokaigodoGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YokaigodoGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.YokaigodoGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.YokaigodoGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YokaigodoGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgYokaigodoGuide = function () {
                return new UZA.DataGrid(this.convFiledName("dgYokaigodoGuide"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        YokaigodoGuide.Controls = Controls;
    })(DBZ.YokaigodoGuide || (DBZ.YokaigodoGuide = {}));
    var YokaigodoGuide = DBZ.YokaigodoGuide;
})(DBZ || (DBZ = {}));
