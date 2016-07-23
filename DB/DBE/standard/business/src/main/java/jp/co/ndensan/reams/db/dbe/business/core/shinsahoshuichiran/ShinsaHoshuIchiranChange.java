/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬一覧表の帳票のパラメータを作成します。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
public class ShinsaHoshuIchiranChange {

    private static final RString 欠 = new RString("欠");
    private static final RString 長 = new RString("長");
    private static final RString 出 = new RString("出");
    private static final RString 副 = new RString("副");
    private static final RString 欠_対応 = new RString("×");
    private static final RString 長_対応 = new RString("○");
    private static final RString 出_対応 = new RString("◎");
    private static final RString 副_対応 = new RString("-");
    private static final RString CSVを出力する = new RString("1");

    /**
     * 審査会委員の作成
     *
     * @param entity ShinsaHoshuIchiranRelateEntity
     * @param 帳票出力区分 帳票出力区分
     * @return ShinsaHoshuIchiranEntity
     */
    public ShinsaHoshuIchiranEntity createData(ShinsaHoshuIchiranRelateEntity entity, RString 帳票出力区分) {

        ShinsaHoshuIchiranRelateEntity 審査会委員 = new ShinsaHoshuIchiranRelateEntity();
        ShinsaHoshuIchiranEntity 委員報酬一覧表;

        審査会委員.set出席状況_1日(set出席状況(entity.get出席状況_1日()));
        審査会委員.set出席状況_2日(set出席状況(entity.get出席状況_2日()));
        審査会委員.set出席状況_3日(set出席状況(entity.get出席状況_3日()));
        審査会委員.set出席状況_4日(set出席状況(entity.get出席状況_4日()));
        審査会委員.set出席状況_5日(set出席状況(entity.get出席状況_5日()));
        審査会委員.set出席状況_6日(set出席状況(entity.get出席状況_6日()));
        審査会委員.set出席状況_7日(set出席状況(entity.get出席状況_7日()));
        審査会委員.set出席状況_8日(set出席状況(entity.get出席状況_8日()));
        審査会委員.set出席状況_9日(set出席状況(entity.get出席状況_9日()));
        審査会委員.set出席状況_10日(set出席状況(entity.get出席状況_10日()));
        審査会委員.set出席状況_11日(set出席状況(entity.get出席状況_11日()));
        審査会委員.set出席状況_12日(set出席状況(entity.get出席状況_12日()));
        審査会委員.set出席状況_13日(set出席状況(entity.get出席状況_13日()));
        審査会委員.set出席状況_14日(set出席状況(entity.get出席状況_14日()));
        審査会委員.set出席状況_15日(set出席状況(entity.get出席状況_15日()));
        審査会委員.set出席状況_16日(set出席状況(entity.get出席状況_16日()));
        審査会委員.set出席状況_17日(set出席状況(entity.get出席状況_17日()));
        審査会委員.set出席状況_18日(set出席状況(entity.get出席状況_18日()));
        審査会委員.set出席状況_19日(set出席状況(entity.get出席状況_19日()));
        審査会委員.set出席状況_20日(set出席状況(entity.get出席状況_20日()));
        審査会委員.set出席状況_21日(set出席状況(entity.get出席状況_21日()));
        審査会委員.set出席状況_22日(set出席状況(entity.get出席状況_22日()));
        審査会委員.set出席状況_23日(set出席状況(entity.get出席状況_23日()));
        審査会委員.set出席状況_24日(set出席状況(entity.get出席状況_24日()));
        審査会委員.set出席状況_25日(set出席状況(entity.get出席状況_25日()));
        審査会委員.set出席状況_26日(set出席状況(entity.get出席状況_26日()));
        審査会委員.set出席状況_27日(set出席状況(entity.get出席状況_27日()));
        審査会委員.set出席状況_28日(set出席状況(entity.get出席状況_28日()));
        審査会委員.set出席状況_29日(set出席状況(entity.get出席状況_29日()));
        審査会委員.set出席状況_30日(set出席状況(entity.get出席状況_30日()));
        審査会委員.set出席状況_31日(set出席状況(entity.get出席状況_31日()));
        if (CSVを出力する.equals(帳票出力区分)) {
            委員報酬一覧表 = new ShinsaHoshuIchiranEntity(
                    new RString(entity.get合議体番号()), entity.get介護認定審査会委員氏名(),
                    entity.get審査会開催年月(), 審査会委員.get出席状況_1日(),
                    審査会委員.get出席状況_2日(), 審査会委員.get出席状況_3日(),
                    審査会委員.get出席状況_4日(), 審査会委員.get出席状況_5日(),
                    審査会委員.get出席状況_6日(), 審査会委員.get出席状況_7日(),
                    審査会委員.get出席状況_8日(), 審査会委員.get出席状況_9日(),
                    審査会委員.get出席状況_10日(), 審査会委員.get出席状況_11日(),
                    審査会委員.get出席状況_12日(), 審査会委員.get出席状況_13日(),
                    審査会委員.get出席状況_14日(), 審査会委員.get出席状況_15日(),
                    審査会委員.get出席状況_16日(), 審査会委員.get出席状況_17日(),
                    審査会委員.get出席状況_18日(), 審査会委員.get出席状況_19日(),
                    審査会委員.get出席状況_20日(), 審査会委員.get出席状況_21日(),
                    審査会委員.get出席状況_22日(), 審査会委員.get出席状況_23日(),
                    審査会委員.get出席状況_24日(), 審査会委員.get出席状況_25日(),
                    審査会委員.get出席状況_26日(), 審査会委員.get出席状況_27日(),
                    審査会委員.get出席状況_28日(), 審査会委員.get出席状況_29日(),
                    審査会委員.get出席状況_30日(), 審査会委員.get出席状況_31日(),
                    new RString(entity.get出席回数()), new RString(entity.get報酬総額().toString()),
                    new RString(entity.getその他費用().toString()),
                    new RString(entity.get税額控除().toString()), new RString(entity.get報酬合計().toString()),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else {
            委員報酬一覧表 = new ShinsaHoshuIchiranEntity(
                    new RString(entity.get合議体番号()), entity.get介護認定審査会委員氏名(),
                    entity.get審査会開催年月(), 審査会委員.get出席状況_1日(),
                    審査会委員.get出席状況_2日(), 審査会委員.get出席状況_3日(),
                    審査会委員.get出席状況_4日(), 審査会委員.get出席状況_5日(),
                    審査会委員.get出席状況_6日(), 審査会委員.get出席状況_7日(),
                    審査会委員.get出席状況_8日(), 審査会委員.get出席状況_9日(),
                    審査会委員.get出席状況_10日(), 審査会委員.get出席状況_11日(),
                    審査会委員.get出席状況_12日(), 審査会委員.get出席状況_13日(),
                    審査会委員.get出席状況_14日(), 審査会委員.get出席状況_15日(),
                    審査会委員.get出席状況_16日(), 審査会委員.get出席状況_17日(),
                    審査会委員.get出席状況_18日(), 審査会委員.get出席状況_19日(),
                    審査会委員.get出席状況_20日(), 審査会委員.get出席状況_21日(),
                    審査会委員.get出席状況_22日(), 審査会委員.get出席状況_23日(),
                    審査会委員.get出席状況_24日(), 審査会委員.get出席状況_25日(),
                    審査会委員.get出席状況_26日(), 審査会委員.get出席状況_27日(),
                    審査会委員.get出席状況_28日(), 審査会委員.get出席状況_29日(),
                    審査会委員.get出席状況_30日(), 審査会委員.get出席状況_31日(),
                    new RString(entity.get出席回数()), new RString(entity.get報酬総額().toString()),
                    new RString(entity.getその他費用().toString()), new RString(entity.get税額控除().toString()),
                    new RString(entity.get報酬合計().toString()), RString.EMPTY,
                    new RString(entity.get総合計_報酬総額().toString()), new RString(entity.get総合計_その他費用().toString()),
                    new RString(entity.get総合計_税控除額().toString()), new RString(entity.get総合計_報酬合計().toString())
            );
        }

        return 委員報酬一覧表;
    }

    /**
     * 出席状況の設定
     *
     * @param 出席状況 原出席状況
     * @return 出席状況の作成結果
     */
    public RString set出席状況(RString 出席状況) {

        if (ShinsaHoshuIchiranChange.長.equals(出席状況)) {
            return ShinsaHoshuIchiranChange.長_対応;
        }
        if (ShinsaHoshuIchiranChange.副.equals(出席状況)) {
            return ShinsaHoshuIchiranChange.副_対応;
        }
        if (ShinsaHoshuIchiranChange.出.equals(出席状況)) {
            return ShinsaHoshuIchiranChange.出_対応;
        }
        if (ShinsaHoshuIchiranChange.欠.equals(出席状況)) {
            return ShinsaHoshuIchiranChange.欠_対応;
        }
        return RString.EMPTY;
    }
}
