/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd581001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチパラメタークラスです．
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoJissiJyokyohyoMybatisParameter implements IMyBatisParameter {

    private boolean is導入形態コード111;
    private boolean is導入形態コード112;
    private boolean is導入形態コード120;
    private RString 概況調査テキストイメージ区分;
    private FlexibleDate 年齢基準日;
    private FlexibleDate 生年月日From2;
    private FlexibleDate 生年月日To2;
    private FlexibleDate 生年月日From;
    private FlexibleDate 生年月日To;
    private boolean is住所;
    private boolean is行政区;
    private boolean is地区2;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private boolean is受給申請事由;
    private boolean is申請区分申請時;
    private boolean is申請区分法令;
    private final RString 導入形態111 = new RString("111");
    private final RString 導入形態112 = new RString("112");
    private final RString 導入形態120 = new RString("120");
    private final RString 地区区分住所 = new RString("JUSHO");
    private final RString 地区区分行政区 = new RString("GYOSEIKU");
    private final RString 地区区分地区２ = new RString("TIKU");
    private final RString 集計単位申請事由 = new RString("ZIYU");
    private final RString 集計単位申請時 = new RString("SHINSEIZI");
    private final RString 集計単位法令 = new RString("HOUREI");
    private FlexibleDate 対象年月日From;
    private FlexibleDate 対象年月日To;
    private RString psmShikibetsuTaisho;

    public YokaigoJissiJyokyohyoMybatisParameter(
            RString 導入形態コード,
            RString 概況調査テキストイメージ区分,
            FlexibleDate 年齢基準日,
            int 年齢From,
            int 年齢To,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            RString 地区区分,
            Code 開始地区コード,
            Code 終了地区コード,
            RString 集計単位,
            FlexibleDate 対象年月日From,
            FlexibleDate 対象年月日To,
            RString psmShikibetsuTaisho) {
        if (導入形態コード.equals(導入形態111)) {
            this.is導入形態コード111 = true;
        } else if (導入形態コード.equals(導入形態112)) {
            this.is導入形態コード112 = true;
        } else if (導入形態コード.equals(導入形態120)) {
            this.is導入形態コード120 = true;
        }
        this.概況調査テキストイメージ区分 = 概況調査テキストイメージ区分;
        this.年齢基準日 = 年齢基準日;
        this.生年月日From2 = 年齢基準日.minusYear(年齢From);
        this.生年月日To2 = 年齢基準日.minusYear(年齢To);
        this.生年月日From = 生年月日From;
        this.生年月日To = 生年月日To;
        if (地区区分.equals(地区区分住所)) {
            this.is住所 = true;
        } else if (地区区分.equals(地区区分行政区)) {
            this.is行政区 = true;
        } else if (地区区分.equals(地区区分地区２)) {
            this.is地区2 = true;
        }
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        if (集計単位.equals(集計単位申請事由)) {
            this.is受給申請事由 = true;
        } else if (集計単位.equals(集計単位申請時)) {
            this.is申請区分申請時 = true;
        } else if (集計単位.equals(集計単位法令)) {
            this.is申請区分法令 = true;
        }
        this.対象年月日From = 対象年月日From;
        this.対象年月日To = 対象年月日To;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
