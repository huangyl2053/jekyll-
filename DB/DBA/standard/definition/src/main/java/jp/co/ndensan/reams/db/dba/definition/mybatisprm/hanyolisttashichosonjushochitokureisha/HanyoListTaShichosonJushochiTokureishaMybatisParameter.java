/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisttashichosonjushochitokureisha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku.JiyuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku.KijunbiKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_他市町村住所地特例者のMyBatisパラメータ。
 *
 * @reamsid_L DBA-1590-030 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListTaShichosonJushochiTokureishaMybatisParameter implements IMyBatisParameter {

    private final RString kijunYMD;
    private final RString haniChushutsunichiFrom;
    private final RString haniChushutsunichiTo;
    private final boolean is直近;
    private final boolean is基準日;
    private final boolean is適用開始日;
    private final boolean is適用開始届出日;
    private final boolean is範囲;
    private final boolean is適用日;
    private final boolean is適用届出日;
    private final boolean is解除日;
    private final boolean is解除届出日;
    private final boolean has範囲抽出日From;
    private final boolean has範囲抽出日To;
    private final boolean is他特例適用者のみ;
    private final boolean is他特例解除者のみ;
    private final boolean has適用事由;
    private final boolean has解除事由;
    private final boolean is施設変更あり;
    private final boolean is施設変更なし;
    private final boolean is年齢;
    private final boolean has年齢範囲開始;
    private final boolean has年齢範囲終了;
    private final RString 生年月日範囲終了;
    private final RString 生年月日範囲開始;
    private final boolean is生年月日;
    private final boolean has生年月日範囲終了;
    private final boolean has生年月日範囲開始;
    private final List<RString> tekiyoJiyu;
    private final List<RString> kaijoJiyu;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param kijunYMD 基準日
     * @param haniChushutsunichiFrom 範囲抽出日From
     * @param haniChushutsunichiTo 範囲抽出日To
     * @param is直近 is直近
     * @param is基準日 is基準日
     * @param is適用開始日 is適用開始日
     * @param is適用開始届出日 is適用開始届出日
     * @param is範囲 is範囲
     * @param is適用日 is適用日
     * @param has範囲抽出日From has範囲抽出日From
     * @param has範囲抽出日To has範囲抽出日To
     * @param is適用届出日 is適用届出日
     * @param is解除日 is解除日
     * @param is解除届出日 is解除届出日
     * @param is他特例適用者のみ is他特例適用者のみ
     * @param is他特例解除者のみ is他特例解除者のみ
     * @param has適用事由 has適用事由
     * @param has解除事由 has解除事由
     * @param tekiyoJiyu 適用事由
     * @param kaijoJiyu 解除事由
     * @param is施設変更あり is施設変更あり
     * @param is施設変更なし is施設変更なし
     * @param is年齢 is年齢
     * @param has年齢範囲開始 has年齢範囲開始
     * @param has年齢範囲終了 has年齢範囲終了
     * @param 生年月日範囲終了 生年月日範囲終了
     * @param 生年月日範囲開始 生年月日範囲開始
     * @param is生年月日 is生年月日
     * @param has生年月日範囲終了 has生年月日範囲終了
     * @param has生年月日範囲開始 has生年月日範囲開始
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     */
    protected HanyoListTaShichosonJushochiTokureishaMybatisParameter(
            RString kijunYMD,
            RString haniChushutsunichiFrom,
            RString haniChushutsunichiTo,
            boolean is直近,
            boolean is基準日,
            boolean is適用開始日,
            boolean is適用開始届出日,
            boolean is範囲,
            boolean is適用日,
            boolean has範囲抽出日From,
            boolean has範囲抽出日To,
            boolean is適用届出日,
            boolean is解除日,
            boolean is解除届出日,
            boolean is他特例適用者のみ,
            boolean is他特例解除者のみ,
            boolean has適用事由,
            boolean has解除事由,
            List<RString> tekiyoJiyu,
            List<RString> kaijoJiyu,
            boolean is施設変更あり,
            boolean is施設変更なし,
            boolean is年齢,
            boolean has年齢範囲開始,
            boolean has年齢範囲終了,
            RDate 生年月日範囲終了,
            RDate 生年月日範囲開始,
            boolean is生年月日,
            boolean has生年月日範囲終了,
            boolean has生年月日範囲開始,
            RString psmShikibetsuTaisho,
            RString psmAtesaki
    ) {
        this.kijunYMD = kijunYMD;
        this.haniChushutsunichiFrom = haniChushutsunichiFrom;
        this.haniChushutsunichiTo = haniChushutsunichiTo;
        this.is直近 = is直近;
        this.is基準日 = is基準日;
        this.is適用開始日 = is適用開始日;
        this.is適用開始届出日 = is適用開始届出日;
        this.is範囲 = is範囲;
        this.is適用日 = is適用日;
        this.has範囲抽出日From = has範囲抽出日From;
        this.has範囲抽出日To = has範囲抽出日To;
        this.is適用届出日 = is適用届出日;
        this.is解除日 = is解除日;
        this.is解除届出日 = is解除届出日;
        this.is他特例適用者のみ = is他特例適用者のみ;
        this.is他特例解除者のみ = is他特例解除者のみ;
        this.has適用事由 = has適用事由;
        this.has解除事由 = has解除事由;
        this.tekiyoJiyu = tekiyoJiyu;
        this.kaijoJiyu = kaijoJiyu;
        this.is施設変更あり = is施設変更あり;
        this.is施設変更なし = is施設変更なし;
        this.is年齢 = is年齢;
        this.has年齢範囲開始 = has年齢範囲開始;
        this.has年齢範囲終了 = has年齢範囲終了;
        if (nullHandan(生年月日範囲終了)) {
            this.生年月日範囲終了 = 生年月日範囲終了.toDateString();
        } else {
            this.生年月日範囲終了 = RString.EMPTY;
        }
        if (nullHandan(生年月日範囲開始)) {
            this.生年月日範囲開始 = 生年月日範囲開始.toDateString();
        } else {
            this.生年月日範囲開始 = RString.EMPTY;
        }
        this.is生年月日 = is生年月日;
        this.has生年月日範囲終了 = has生年月日範囲終了;
        this.has生年月日範囲開始 = has生年月日範囲開始;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
    }

    /**
     * パラメータを作成します。
     *
     * @param 宛名抽出年齢開始 宛名抽出年齢開始
     * @param 宛名抽出年齢終了 宛名抽出年齢終了
     * @param 宛名抽出生年月日開始 宛名抽出生年月日開始
     * @param 宛名抽出生年月日終了 宛名抽出生年月日終了
     * @param 年齢基準日 年齢基準日
     * @param 年齢層抽出方法 年齢層抽出方法
     * @param 日付抽出区分 日付抽出区分
     * @param 基準日区分 基準日区分
     * @param 基準日 基準日
     * @param 範囲抽出日区分 範囲抽出日区分
     * @param 範囲抽出日From 範囲抽出日From
     * @param 範囲抽出日To 範囲抽出日To
     * @param 事由抽出区分 事由抽出区分
     * @param tekiyoJiyu 適用事由
     * @param kaijoJiyu 解除事由
     * @param is施設変更あり is施設変更あり
     * @param is施設変更なし is施設変更なし
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @return HanyoListTaShichosonJushochiTokureishaMybatisParameter
     */
    public static HanyoListTaShichosonJushochiTokureishaMybatisParameter creatParameter(
            Decimal 宛名抽出年齢開始,
            Decimal 宛名抽出年齢終了,
            RDate 宛名抽出生年月日開始,
            RDate 宛名抽出生年月日終了,
            RDate 年齢基準日,
            RString 年齢層抽出方法,
            RString 日付抽出区分,
            RString 基準日区分,
            RString 基準日,
            RString 範囲抽出日区分,
            RString 範囲抽出日From,
            RString 範囲抽出日To,
            RString 事由抽出区分,
            List<RString> tekiyoJiyu,
            List<RString> kaijoJiyu,
            boolean is施設変更あり,
            boolean is施設変更なし,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        boolean is年齢 = false;
        boolean is生年月日 = false;
        boolean is直近 = false;
        boolean is基準日 = false;
        boolean is適用開始日 = false;
        boolean is適用開始届出日 = false;
        boolean is範囲 = false;
        boolean is適用日 = false;
        boolean is適用届出日 = false;
        boolean is解除日 = false;
        boolean is解除届出日 = false;
        boolean is他特例適用者のみ = false;
        boolean is他特例解除者のみ = false;
        if (HizukeChushutsuKubun.直近.getコード().equals(日付抽出区分)) {
            is直近 = true;
        } else if (HizukeChushutsuKubun.基準日.getコード().equals(日付抽出区分)) {
            is基準日 = true;
        } else if (HizukeChushutsuKubun.範囲.getコード().equals(日付抽出区分)) {
            is範囲 = true;
        }
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法)) {
            is年齢 = true;
        } else if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(年齢層抽出方法)) {
            is生年月日 = true;
        }
        boolean has年齢範囲開始 = nullHandan(宛名抽出年齢開始);
        boolean has年齢範囲終了 = nullHandan(宛名抽出年齢終了);
        if (!nullHandan(年齢基準日)) {
            年齢基準日 = RDate.getNowDate();
        }
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法) && 宛名抽出年齢開始 != null) {
            宛名抽出生年月日終了 = 年齢基準日.minusYear(宛名抽出年齢開始.add(1).intValue()).plusDay(2);
        }
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法) && 宛名抽出年齢終了 != null) {
            宛名抽出生年月日開始 = 年齢基準日.minusYear(宛名抽出年齢終了.intValue()).plusDay(1);
        }
        boolean has生年月日範囲開始 = nullHandan(宛名抽出生年月日開始);
        boolean has生年月日範囲終了 = nullHandan(宛名抽出生年月日終了);
        if (KijunbiKubun.適用開始日.getコード().equals(基準日区分)) {
            is適用開始日 = true;
        } else if (KijunbiKubun.適用開始届出日.getコード().equals(基準日区分)) {
            is適用開始届出日 = true;
        }
        if (HaniChushutsubiKubun.適用日.getコード().equals(範囲抽出日区分)) {
            is適用日 = true;
        } else if (HaniChushutsubiKubun.適用届出日.getコード().equals(範囲抽出日区分)) {
            is適用届出日 = true;
        } else if (HaniChushutsubiKubun.解除日.getコード().equals(範囲抽出日区分)) {
            is解除日 = true;
        } else if (HaniChushutsubiKubun.解除届出日.getコード().equals(範囲抽出日区分)) {
            is解除届出日 = true;
        }
        boolean has範囲抽出日From = nullHandan(範囲抽出日From);
        boolean has範囲抽出日To = nullHandan(範囲抽出日To);
        if (JiyuChushutsuKubun.他特例適用者のみ.getコード().equals(事由抽出区分)) {
            is他特例適用者のみ = true;
        } else if (JiyuChushutsuKubun.他特例解除者のみ.getコード().equals(事由抽出区分)) {
            is他特例解除者のみ = true;
        }
        boolean has適用事由 = nullHandan(tekiyoJiyu);
        boolean has解除事由 = nullHandan(kaijoJiyu);
        return new HanyoListTaShichosonJushochiTokureishaMybatisParameter(
                基準日,
                範囲抽出日From,
                範囲抽出日To,
                is直近,
                is基準日,
                is適用開始日,
                is適用開始届出日,
                is範囲,
                is適用日,
                has範囲抽出日From,
                has範囲抽出日To,
                is適用届出日,
                is解除日,
                is解除届出日,
                is他特例適用者のみ,
                is他特例解除者のみ,
                has適用事由,
                has解除事由,
                tekiyoJiyu,
                kaijoJiyu,
                is施設変更あり,
                is施設変更なし,
                is年齢,
                has年齢範囲開始,
                has年齢範囲終了,
                宛名抽出生年月日終了,
                宛名抽出生年月日開始,
                is生年月日,
                has生年月日範囲終了,
                has生年月日範囲開始,
                psmShikibetsuTaisho,
                psmAtesaki);
    }

    private static boolean nullHandan(Decimal 宛名抽出年齢) {
        return 宛名抽出年齢 != null;
    }

    private static boolean nullHandan(RDate 年月日) {
        return 年月日 != null;
    }

    private static boolean nullHandan(RString 抽出日) {
        return !RString.isNullOrEmpty(抽出日);
    }

    private static boolean nullHandan(List<RString> jiyu) {
        return jiyu != null && !jiyu.isEmpty();
    }

}
