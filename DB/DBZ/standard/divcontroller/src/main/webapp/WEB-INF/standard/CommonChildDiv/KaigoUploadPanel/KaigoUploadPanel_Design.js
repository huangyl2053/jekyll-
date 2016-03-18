var DBZ;
(function (DBZ) {
    (function (KaigoUploadPanel) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_BtnUpload = function () {
                return "onClick_BtnUpload";
            };
            return Events;
        })();
        KaigoUploadPanel.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoUploadPanel";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoUploadPanel.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoUploadPanel.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoUploadPanel = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.uplUploadFile = function () {
                return new UZA.UploadPanel(this.convFiledName("uplUploadFile"));
            };

            Controls.prototype.lblFileName = function () {
                return new UZA.Label(this.convFiledName("lblFileName"));
            };

            Controls.prototype.lblUploadFileName = function () {
                return new UZA.Label(this.convFiledName("lblUploadFileName"));
            };

            Controls.prototype.btnUpload = function () {
                return new UZA.Button(this.convFiledName("btnUpload"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KaigoUploadPanel.Controls = Controls;
    })(DBZ.KaigoUploadPanel || (DBZ.KaigoUploadPanel = {}));
    var KaigoUploadPanel = DBZ.KaigoUploadPanel;
})(DBZ || (DBZ = {}));
