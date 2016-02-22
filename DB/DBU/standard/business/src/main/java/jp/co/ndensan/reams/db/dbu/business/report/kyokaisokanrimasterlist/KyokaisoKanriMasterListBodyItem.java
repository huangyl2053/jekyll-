/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 境界層管理マスタリストボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoKanriMasterListBodyItem {

    private final List<RString> listUpper_1;
    private final List<RString> listUpper_2;
    private final List<RString> listUpper_3;
    private final List<RString> listUpper_4;
    private final List<RString> listUpper_5;
    private final List<RString> listUpper_6;
    private final List<RString> listUpper_7;
    private final List<RString> listUpper_8;
    private final List<RString> listUpper_9;
    private final List<RString> listLower_1;
    private final List<RString> listLower_2;
    private final List<RString> listLower_3;
    private final List<RString> listLower_4;
    private final List<RString> listLower_5;
    private final List<RString> listLower_6;
    private final List<RString> listLower_7;
    private final List<RString> listLower_8;
    private final List<RString> listLower_9;
    private final List<RString> listLower_10;

    /**
     * インスタンスを生成します。
     *
     * @param listUpper_1 被保険者番号
     * @param listUpper_2 カナ氏名
     * @param listUpper_3 性別
     * @param listUpper_4 種別
     * @param listUpper_5 住民状態
     * @param listUpper_6 生年月日
     * @param listUpper_7 該当開始日
     * @param listUpper_8 給付額減額解除
     * @param listUpper_9 特定居住費等減額居室の種類
     * @param listLower_1 識別コード
     * @param listLower_2 氏名
     * @param listLower_3 世帯コード
     * @param listLower_4 該当申請日
     * @param listLower_5 該当終了日
     * @param listLower_6 標準負担減額後負担額
     * @param listLower_7 特定居住費等減額後負担額
     * @param listLower_8 特定食費減額後負担額
     * @param listLower_9 高額ｻｰﾋﾞｽ費低減後世帯上限額
     * @param listLower_10 納付額低減後所得段階
     */
    public KyokaisoKanriMasterListBodyItem(
            List<RString> listUpper_1,
            List<RString> listUpper_2,
            List<RString> listUpper_3,
            List<RString> listUpper_4,
            List<RString> listUpper_5,
            List<RString> listUpper_6,
            List<RString> listUpper_7,
            List<RString> listUpper_8,
            List<RString> listUpper_9,
            List<RString> listLower_1,
            List<RString> listLower_2,
            List<RString> listLower_3,
            List<RString> listLower_4,
            List<RString> listLower_5,
            List<RString> listLower_6,
            List<RString> listLower_7,
            List<RString> listLower_8,
            List<RString> listLower_9,
            List<RString> listLower_10) {

        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listUpper_9 = listUpper_9;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
        this.listLower_8 = listLower_8;
        this.listLower_9 = listLower_9;
        this.listLower_10 = listLower_10;
    }
}
