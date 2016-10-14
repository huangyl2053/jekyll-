/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果連携データ取込作成画面バリデーションクラスです。
 *
 * @reamsid_L DBD_1510-010 liuyl
 */
public enum YogaigoNinteiKekkaRenkeiDataTorikomiDivSpec implements IPredicate<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> {

    取込みファイル内容一覧対象未選択チェック {
        /**
         * 取込みファイル内容一覧対象未選択チェック。
         *
         * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
         * @return boolean
         */
        @Override
        public boolean apply(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
            return div.getDgtorikomidataichiran().getSelectedItems() != null
                    && !div.getDgtorikomidataichiran().getSelectedItems().isEmpty();
        }
    },
    保険者一致チェック_保険者番号 {
        /**
         * 保険者一致チェック(保険者番号)。
         *
         * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
         * @return boolean
         */
        @Override
        public boolean apply(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
            for (dgtorikomidataichiran_Row row : div.getDgtorikomidataichiran().getSelectedItems()) {
                if (!row.getHokenshano().equals(div.getHokenshaList().getSelectedItem().get証記載保険者番号().value())) {
                    return false;
                }
            }
            return true;
        }
    },
    保険者一致チェック_識別コード {
        /**
         * 保険者一致チェック(識別コード)。
         *
         * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
         * @return boolean
         */
        @Override
        public boolean apply(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
            List<dgtorikomidataichiran_Row> dataSources = div.getDgtorikomidataichiran().getDataSource();
            if (dataSources.size() >= 2) {
                for (int i = 0; i < dataSources.size() - 1; i++) {
                    if (!dataSources.get(i).getShikibetsuCode().equals(dataSources.get(i + 1).getShikibetsuCode())) {
                        return false;
                    }
                }
            }
            return true;
        }
    },
    ファイルチェック {
        /**
         * ファイルチェック。
         *
         * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
         * @return boolean
         */
        @Override
        public boolean apply(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
            return div.getHdNum().getValue().equals(new RString("0")) && div.getUploadTool().getRemainUnUploadedFiles().get(0).
                    equalsIgnoreCase(div.getDataGridFile().getDataSource().get(0).getFileName());
        }
    }
}
