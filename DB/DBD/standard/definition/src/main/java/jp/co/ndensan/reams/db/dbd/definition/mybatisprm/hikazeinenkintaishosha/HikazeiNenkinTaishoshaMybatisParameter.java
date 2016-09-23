/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hikazeinenkintaishosha;

import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(非課税年金対象者)のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HikazeiNenkinTaishoshaMybatisParameter implements IMyBatisParameter {

    private static final RString 年指定_年度 = new RString("11");
    private static final RString 年指定_年 = new RString("12");
    private static final RString 被保険者抽出_被保険者のみ = new RString("1");
    private static final RString 被保険者抽出_被保険者以外のみ = new RString("2");
    private static final RString 年齢 = new RString("年齢");
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private final boolean is年度;
    private final boolean is対象年;
    private final boolean is被保険者のみ;
    private final boolean is被保険者以外のみ;
    private final boolean has年齢From;
    private final boolean has年齢To;
    private final boolean has生年月日From;
    private final boolean has生年月日To;
    private final boolean has保険者コード;
    private final boolean is最新情報;
    private final RString 年度BP;
    private final RString 年齢From逆算;
    private final RString 年齢To逆算;
    private final RString 生年月日From;
    private final RString 生年月日To;
    private final LasdecCode 保険者コード;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     *
     * @param is年度 is年度
     * @param is対象年 is対象年
     * @param is被保険者のみ is被保険者のみ
     * @param is被保険者以外のみ is被保険者以外のみ
     * @param has年齢From has年齢From
     * @param has年齢To has年齢To
     * @param has生年月日From has生年月日From
     * @param has生年月日To has生年月日To
     * @param has保険者コード has保険者コード
     * @param is最新情報 is最新情報
     * @param 年度BP 年度BP
     * @param 年齢From逆算 年齢From逆算
     * @param 年齢To逆算 年齢To逆算
     * @param 生年月日From 生年月日From
     * @param 生年月日To 生年月日To
     * @param 保険者コード 保険者コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     */
    private HikazeiNenkinTaishoshaMybatisParameter(
            boolean is年度,
            boolean is対象年,
            boolean is被保険者のみ,
            boolean is被保険者以外のみ,
            boolean has年齢From,
            boolean has年齢To,
            boolean has生年月日From,
            boolean has生年月日To,
            boolean has保険者コード,
            boolean is最新情報,
            RString 年度BP,
            RString 年齢From逆算,
            RString 年齢To逆算,
            RString 生年月日From,
            RString 生年月日To,
            LasdecCode 保険者コード,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        this.is年度 = is年度;
        this.is対象年 = is対象年;
        this.is被保険者のみ = is被保険者のみ;
        this.is被保険者以外のみ = is被保険者以外のみ;
        this.has年齢From = has年齢From;
        this.has年齢To = has年齢To;
        this.has生年月日From = has生年月日From;
        this.has生年月日To = has生年月日To;
        this.has保険者コード = has保険者コード;
        this.is最新情報 = is最新情報;
        this.年度BP = 年度BP;
        this.年齢From逆算 = 年齢From逆算;
        this.年齢To逆算 = 年齢To逆算;
        this.生年月日From = 生年月日From;
        this.保険者コード = 保険者コード;
        this.生年月日To = 生年月日To;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
    }

    /**
     *
     * @param 抽出方法 抽出方法
     * @param 被保険者抽出方法 被保険者抽出方法
     * @param 宛名抽出条件 宛名抽出条件
     * @param is最新情報 is最新情報
     * @param 年度BP 年度BP
     * @param date date
     * @param 年齢From 年齢From
     * @param 年齢To 年齢To
     * @param 年齢From逆算 年齢From逆算
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 年齢To逆算 年齢To逆算
     * @param psmAtesaki psmAtesaki
     * @return HikazeiNenkinTaishoshaMybatisParameter
     */
    public static HikazeiNenkinTaishoshaMybatisParameter createMybatisParameter(
            RString 抽出方法,
            RString 被保険者抽出方法,
            AtenaSelectBatchParameter 宛名抽出条件,
            boolean is最新情報,
            RString 年度BP,
            RDate date,
            int 年齢From,
            int 年齢To,
            RString 年齢From逆算,
            RString 年齢To逆算,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        boolean is年度 = false;
        boolean is対象年 = false;
        boolean is被保険者のみ = false;
        boolean is被保険者以外のみ = false;
        boolean has年齢From = false;
        boolean has年齢To = false;
        boolean has生年月日From = false;
        boolean has生年月日To = false;
        boolean has保険者コード = false;
        RString 生年月日From = get生年月日(宛名抽出条件.getSeinengappiRange().getFrom());
        RString 生年月日To = get生年月日(宛名抽出条件.getSeinengappiRange().getTo());
        if (!RString.isNullOrEmpty(年度BP)) {
            if (年指定_年度.equals(抽出方法)) {
                is年度 = true;
            }
            if (年指定_年.equals(抽出方法)) {
                is対象年 = true;
            }
        }
        if (被保険者抽出_被保険者のみ.equals(被保険者抽出方法)) {
            is被保険者のみ = true;
        }
        if (被保険者抽出_被保険者以外のみ.equals(被保険者抽出方法)) {
            is被保険者以外のみ = true;
        }
        RString 年齢層抽出方法 = 宛名抽出条件.getAgeSelectKijun().get名称();
        if (年齢.equals(年齢層抽出方法)) {
            if (年齢From != 0) {
                has年齢From = true;
            }
            if (年齢To != 0) {
                has年齢To = true;
            }
        } else {
            if (!RString.isNullOrEmpty(生年月日From)) {
                has生年月日From = true;
            }
            if (!RString.isNullOrEmpty(生年月日To)) {
                has生年月日To = true;
            }
        }
        LasdecCode 保険者コード = 宛名抽出条件.getShichoson_Code();
        if (!保険者コード.isEmpty()
                || 市町村コード.equals(保険者コード)) {
            has保険者コード = true;
        }
        return new HikazeiNenkinTaishoshaMybatisParameter(
                is年度,
                is対象年,
                is被保険者のみ,
                is被保険者以外のみ,
                has年齢From,
                has年齢To,
                has生年月日From,
                has生年月日To,
                has保険者コード,
                is最新情報,
                年度BP,
                年齢From逆算,
                年齢To逆算,
                生年月日From,
                生年月日To,
                保険者コード,
                psmShikibetsuTaisho,
                psmAtesaki);
    }

    private static RString get生年月日(RDate value) {
        if (value == null) {
            return RString.EMPTY;
        } else {
            return value.toDateString();
        }
    }
}
