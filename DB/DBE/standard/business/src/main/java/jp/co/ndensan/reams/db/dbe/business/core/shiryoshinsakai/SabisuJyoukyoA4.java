/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.NitijouSeikatsu;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TyukanHyouka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class SabisuJyoukyoA4 {

    private static final RString 月間 = new RString("月間");
    private static final Code A_99 = new Code("99A");
    private static final Code A_02 = new Code("02A");
    private static final Code A_06 = new Code("06A");
    private static final Code A_09 = new Code("09A");
    private static final Code B_09 = new Code("09B");
    private static final RString 記号 = new RString("+");

    /**
     * 項目の設定する。
     *
     * @param 項目 IchijihanteikekkahyoA4Entity
     * @param entity ItiziHanteiEntity
     */
    public void set項目(IchijihanteikekkahyoA4Entity 項目, ItiziHanteiEntity entity) {
        項目.set審査順(new RString(entity.getShinsakaiOrder()));
        項目.set年齢(new RString(entity.getAge()));
        項目.set前々回要介護度(set要介護度(entity.getZzKoroshoIfShikibetsuCode(), entity.getZzNijiHanteiYokaigoJotaiKubunCode()));
        項目.set前々回認定有効期間(set有効期間(entity.getZzNijiHanteiNinteiYukoKikan()));
        項目.set前々回認定有効期間開始年月日(entity.getZzNijiHanteiNinteiYukoKaishiYMD());
        項目.set前々回認定有効期間終了年月日(entity.getZzNijiHanteiNinteiYukoShuryoYMD());
        項目.set前回要介護度(set要介護度(entity.getZKoroshoIfShikibetsuCode(), entity.getZNijiHanteiYokaigoJotaiKubunCode()));
        項目.set前回認定有効期間(set有効期間(entity.getZNijiHanteiNinteiYukoKikan()));
        項目.set前回認定有効期間開始年月日(entity.getZNijiHanteiNinteiYukoKaishiYMD());
        項目.set前回認定有効期間終了年月日(entity.getZNijiHanteiNinteiYukoShuryoYMD());
        項目.set前回認定日(entity.getZNijiHanteiYMD());
        項目.set前回状態像(set状態像(entity.getZYokaigoJotaizoReiCode()));
        項目.set審査会資料作成年月日(FlexibleDate.getNowDate());
        項目.set今回認定申請年月日(entity.getNinteiShinseiYMD());
        項目.set今回認定調査実施年月日(entity.getNinteichosaJisshiYMD());
        項目.set今回認定審査年月日(entity.getShinsakaiKaisaiYMD());
        項目.set被保険者番号(entity.getHihokenshaNo());
        項目.set保険者番号(entity.getShoKisaiHokenshaNo());
        項目.set支所名(entity.getShishoMei());
        項目.set市町村名(entity.getShichosonMeisho());
        項目.set事業者番号(entity.getNinteichosaItakusakiCode());
        項目.set事業者名(entity.getJigyoshaMeisho());
        項目.set認定調査員番号(entity.getNinteiChosainCode());
        項目.set認定調査員氏名(entity.getChosainShimei());
        項目.set医療機関番号(entity.getShujiiIryokikanCode());
        項目.set医療機関名称(entity.getIryoKikanMeisho());
        項目.set主治医番号(entity.getShujiiCode());
        項目.set主治医氏名(entity.getShujiiName());
        項目.set一次判定結果(set一次判定結果(entity.getKoroshoIfShikibetsuCode(),
                entity.getIchijiHanteiKekkaCode(), entity.getIchijiHanteiKekkaNinchishoKasanCode()));
        項目.set状態像名称(entity.getJotaizo());
        項目.set要介護認定等基準時間(set要介護認定等基準時間(entity.getKijunJikanShokuji(), entity.getKijunJikanHaisetsu(),
                entity.getKijunJikanIdo(), entity.getKijunJikanSeiketsuHoji(), entity.getKijunJikanKansetsuCare(),
                entity.getKijunJikanBPSDKanren(), entity.getKijunJikanKinoKunren(), entity.getKijunJikanIryoKanren(),
                entity.getKijunJikanNinchishoKasan(), entity.getKijunJikan()));
        //TODO QA回答まち、
//        項目.set基準時間の積み上げグラフ(月間);
        項目.set要介護認定等基準時間_食事(new RString(entity.getKijunJikanShokuji()));
        項目.set要介護認定等基準時間_排泄(new RString(entity.getKijunJikanHaisetsu()));
        項目.set要介護認定等基準時間_移動(new RString(entity.getKijunJikanIdo()));
        項目.set要介護認定等基準時間_清潔保持(new RString(entity.getKijunJikanSeiketsuHoji()));
        項目.set要介護認定等基準時間_間接(new RString(entity.getKijunJikanKansetsuCare()));
        項目.set要介護認定等基準時間_BPSD関連(new RString(entity.getKijunJikanBPSDKanren()));
        項目.set要介護認定等基準時間_機能訓練(new RString(entity.getKijunJikanKinoKunren()));
        項目.set要介護認定等基準時間_医療関連(new RString(entity.getKijunJikanIryoKanren()));
        項目.set要介護認定等基準時間_認知症加算(new RString(entity.getKijunJikanNinchishoKasan()));
        項目.set警告コード(entity.getIchijiHnateiKeikokuCode());
        TyukanHyouka 中間評価項目 = new TyukanHyouka();
        中間評価項目.set第1群(new RString(entity.getChukanHyokaKomoku1gun()));
        中間評価項目.set第2群(new RString(entity.getChukanHyokaKomoku2gun()));
        中間評価項目.set第3群(new RString(entity.getChukanHyokaKomoku3gun()));
        中間評価項目.set第4群(new RString(entity.getChukanHyokaKomoku4gun()));
        中間評価項目.set第5群(new RString(entity.getChukanHyokaKomoku5gun()));
        List<TyukanHyouka> 中間評価リスト = new ArrayList<>();
        中間評価リスト.add(中間評価項目);
        項目.set中間評価リスト(中間評価リスト);
        List<NitijouSeikatsu> 日常生活自立度リスト = new ArrayList<>();
        NitijouSeikatsu 障害高齢者自立度 = new NitijouSeikatsu();
        障害高齢者自立度.set特記事項フラグ(entity.getShogaiNichijoSeikatsuJiritsudo());
        障害高齢者自立度.set認知症高齢者自立度(set障害高齢者自立度(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
        NitijouSeikatsu 認知症高齢者自立度 = new NitijouSeikatsu();
        認知症高齢者自立度.set特記事項フラグ(entity.getNinchishoNichijoSeikatsuJiritsudo());
        認知症高齢者自立度.set認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        日常生活自立度リスト.add(障害高齢者自立度);
        日常生活自立度リスト.add(認知症高齢者自立度);
        項目.set日常生活自立度リスト(日常生活自立度リスト);
        項目.set認定調査結果認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        項目.set意見書認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        if (RString.isNullOrEmpty(entity.getHihokenshaKubunCode())) {
            項目.set被保険者区分(RString.EMPTY);
        } else {
            項目.set被保険者区分(HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称());
            if (HihokenshaKubunCode.第１号被保険者.getコード().equals(entity.getHihokenshaKubunCode())
                    || entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty()) {
                項目.set特定疾病名(RString.EMPTY);
            } else {
                項目.set特定疾病名(TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode().getColumnValue()).get名称());
            }
        }
        if (entity.getNinteiShinseiShinseijiKubunCode() == null || entity.getNinteiShinseiShinseijiKubunCode().isEmpty()) {
            項目.set申請区分(RString.EMPTY);
        } else {
            項目.set申請区分(NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCode().getColumnValue()).get名称());
        }
        if (entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty()) {
            項目.set性別(RString.EMPTY);
        } else {
            項目.set性別(Seibetsu.toValue(entity.getSeibetsu().getColumnValue()).get名称());
        }
        if (entity.getShinseishoKanriNo() == null || entity.getShinseishoKanriNo().isEmpty()) {
            項目.set管理番号(RString.EMPTY);
        } else {
            項目.set管理番号(entity.getShinseishoKanriNo().getColumnValue());
        }
        if (entity.getHihokenshaName() == null || entity.getHihokenshaName().isEmpty()) {
            項目.set被保険者氏名(RString.EMPTY);
        } else {
            項目.set被保険者氏名(entity.getHihokenshaName().getColumnValue());
        }
        if (RString.isNullOrEmpty(entity.getChosainShikaku())) {
            項目.set調査員資格(RString.EMPTY);
        } else {
            項目.set調査員資格(Sikaku.toValue(entity.getChosainShikaku()).get名称());
        }
        if (entity.getNinchishoJiritsudoIIijoNoGaizensei() == null) {
            項目.set認知症自立度Ⅱ以上の蓋然性(RString.EMPTY);
        } else {
            項目.set認知症自立度Ⅱ以上の蓋然性(new RString(entity.getNinchishoJiritsudoIIijoNoGaizensei().toString()));
        }
        if (entity.getJotaiAnteiseiCode() == null || entity.getJotaiAnteiseiCode().isEmpty()) {
            項目.set状態の安定性(RString.EMPTY);
        } else {
            項目.set状態の安定性(JotaiAnteiseiCode.toValue(entity.getJotaiAnteiseiCode().getColumnValue()).get名称());
        }
        if (entity.getSuiteiKyufuKubunCode() == null || entity.getSuiteiKyufuKubunCode().isEmpty()) {
            項目.set給付区分(RString.EMPTY);
        } else {
            項目.set給付区分(SuiteiKyufuKubunCode.toValue(entity.getSuiteiKyufuKubunCode().getColumnValue()).get名称());
        }
    }

    private RString set要介護度(Code 厚労省IF識別コード, Code 二次判定要介護状態区分コード) {
        if (二次判定要介護状態区分コード != null && !二次判定要介護状態区分コード.isEmpty()) {
            if (A_99.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun02.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun06.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun09.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString set状態像(Code 状態像) {
        if (状態像 != null && !状態像.isEmpty()) {
            return YokaigoJotaizoReiCode.toValue(状態像.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString set一次判定結果(Code 厚労省IF識別コード, Code 一次判定結果コード, Code 一次判定結果コード_認知症加算) {
        RString 一次判定結果 = RString.EMPTY;
        RString 一次判定結果_認知症加算 = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (一次判定結果コード != null && !一次判定結果コード.isEmpty()) {
            if (A_99.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun99.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun02.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun06.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun09.toValue(一次判定結果コード.getColumnValue()).get名称();
            }
        }
//        if (一次判定結果コード_認知症加算 != null && !一次判定結果コード_認知症加算.isEmpty()) {
//            if (A_99.equals(厚労省IF識別コード)) {
//                一次判定結果_認知症加算 = YokaigoJotaiKubun99.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
//            } else if (A_02.equals(厚労省IF識別コード)) {
//                一次判定結果_認知症加算 = YokaigoJotaiKubun02.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
//            } else if (A_06.equals(厚労省IF識別コード)) {
//                一次判定結果_認知症加算 = YokaigoJotaiKubun06.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
//            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
//                一次判定結果_認知症加算 = YokaigoJotaiKubun09.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
//            }
//        }
        return builder.append(一次判定結果)
                .append("→")
                .append(一次判定結果_認知症加算).toRString();
    }

    private RString set要介護認定等基準時間(int 食事, int 排泄,
            int 移動, int 清潔保持, int 間接,
            int 関連, int 機能訓練, int 医療関連,
            int 認知症加算, int 基準時間) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(new RString(食事)).append(記号)
                .append(new RString(排泄)).append(記号)
                .append(new RString(移動)).append(記号)
                .append(new RString(清潔保持)).append(記号)
                .append(new RString(間接)).append(記号)
                .append(new RString(関連)).append(記号)
                .append(new RString(機能訓練)).append(記号)
                .append(new RString(医療関連)).append(記号)
                .append(new RString(認知症加算)).append(new RString("="))
                .append(new RString(基準時間))
                .toRString();
    }

    private RString set障害高齢者自立度(Code 障害高齢者自立度コード) {
        if (障害高齢者自立度コード != null && !障害高齢者自立度コード.isEmpty()) {
            return ShogaiNichijoSeikatsuJiritsudoCode.toValue(障害高齢者自立度コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString set有効期間(int 有効期間) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(有効期間)
                .append(月間);
        return builder.toRString();
    }

    private RString set認知症高齢者自立度(Code 認知症高齢者自立度コード) {
        if (認知症高齢者自立度コード != null && !認知症高齢者自立度コード.isEmpty()) {
            return NinchishoNichijoSeikatsuJiritsudoCode.toValue(認知症高齢者自立度コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

}
