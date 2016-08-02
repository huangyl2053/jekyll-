/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5610001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5610001.KoshinTaishoshaKanriMyBatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新対象者抽出作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinTaishoshaKanriProcessParameter implements IBatchProcessParameter {

    private final RString 前回以降の未処理分 = new RString("前回以降の未処理分");
    private final RString 有効期間終了日を範囲指定する = new RString("有効期間終了日を範囲指定する");
    private final RString shoriJotaiKubun = ShoriJotaiKubun.通常.getコード();
    private RString 条件指定;
    private FlexibleDate 有効期間終了日From;
    private FlexibleDate 有効期間終了日To;
    private FlexibleYearMonth 対象月;
    private LasdecCode 市町村コード;
    private FlexibleYear 年度;
    private RString 年度内連番;

    /**
     *
     * @return KoshinTaishoshaKanriMyBatisParameter
     */
    public KoshinTaishoshaKanriMyBatisParameter toKoshinTaishoshaKanriMyBatisParameter() {
        if (this.条件指定.equals(前回以降の未処理分)) {
            return new KoshinTaishoshaKanriMyBatisParameter(true, false, 有効期間終了日From,
                    有効期間終了日To, 対象月.toDateString(), shoriJotaiKubun);
        }
        if (this.条件指定.equals(有効期間終了日を範囲指定する)) {
            return new KoshinTaishoshaKanriMyBatisParameter(false, true, 有効期間終了日From,
                    有効期間終了日To, 対象月.toDateString(), shoriJotaiKubun);
        } else {
            return null;
        }
    }

    /**
     *
     * @param 条件指定 条件指定
     * @param 有効期間終了日From 有効期間終了日From
     * @param 有効期間終了日To 有効期間終了日To
     * @param 対象月 対象月
     * @param 市町村コード 市町村コード
     * @param 年度 年度
     * @param 年度内連番 年度内連番
     */
    public KoshinTaishoshaKanriProcessParameter(RString 条件指定, FlexibleDate 有効期間終了日From, FlexibleDate 有効期間終了日To,
            FlexibleYearMonth 対象月, LasdecCode 市町村コード, FlexibleYear 年度, RString 年度内連番) {
        this.条件指定 = 条件指定;
        this.有効期間終了日From = 有効期間終了日From;
        this.有効期間終了日To = 有効期間終了日To;
        this.対象月 = 対象月;
        this.市町村コード = 市町村コード;
        this.年度 = 年度;
        this.年度内連番 = 年度内連番;
    }
}
