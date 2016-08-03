/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.NitijouSeikatsu;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TyukanHyouka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiA3 {

    private static final RString 月間 = new RString("月間");
    private static final Code A_99 = new Code("99A");
    private static final Code A_02 = new Code("02A");
    private static final Code A_06 = new Code("06A");
    private static final Code A_09 = new Code("09A");
    private static final Code B_09 = new Code("09B");
    private static final RString 段階悪化 = new RString("▲");
    private static final RString 段階改善 = new RString("▽");
//    private static final RString 印字する = new RString("1");
    private static final RString 記号 = new RString("+");

    /**
     * 事務局一次判定結果票Entityの設定。
     *
     * @param entity ItiziHanteiEntity
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @param 調査票調査項目 調査票調査項目
     * @param 前回調査票調査項目 前回調査票調査項目
     * @param 主治医意見書項目情報 主治医意見書項目情報
     * @param 前主治医意見書項目情報 前主治医意見書項目情報
     * @param サービス状況フラグ サービス状況フラグ
     * @param 予防給付 予防給付
     * @param 介護給付 介護給付
     * @param データ件数 データ件数
     * @param 共通情報 共通情報
     * @return 事務局一次判定結果票のEntity
     */
    public IchijihanteikekkahyoA3Entity set項目(ItiziHanteiEntity entity,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報, List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付,
            List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付, DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ,
            int データ件数, ShinsakaiSiryoKyotsuEntity 共通情報) {
        IchijihanteikekkahyoA3Entity 項目 = new IchijihanteikekkahyoA3Entity();
        IchijihanteikekkahyoItemSetteiTwoA3 settei = new IchijihanteikekkahyoItemSetteiTwoA3();
        Code 厚労省IF識別コード = entity.getKoroshoIfShikibetsuCode();
        コード転換(項目, entity);
        項目.set審査人数(new RString(entity.getShinsakaiOrder()));
        項目.set審査人数合計(new RString(データ件数));
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
        項目.set市町村名(entity.getShichosonMeisho());
        項目.set事業者番号(entity.getNinteichosaItakusakiCode());
        項目.set事業者名(entity.getJigyoshaMeisho());
        項目.set認定調査員番号(entity.getNinteiChosainCode());
        項目.set認定調査員氏名(entity.getChosainShimei());
        項目.set調査日(entity.getNinteichosaJisshiYMD());
        項目.set調査実施場所(entity.getChosaJisshiBashoMeisho());
        項目.set医療機関番号(entity.getShujiiIryokikanCode());
        項目.set医療機関名称(entity.getIryoKikanMeisho());
        項目.set主治医番号(entity.getShujiiCode());
        項目.set主治医氏名(entity.getShujiiName());
        項目.set一次判定結果(set一次判定結果(entity.getKoroshoIfShikibetsuCode(),
                entity.getIchijiHanteiKekkaCode(), entity.getIchijiHanteiKekkaNinchishoKasanCode()));
        項目.set要介護認定等基準時間(set要介護認定等基準時間(entity.getKijunJikanShokuji(), entity.getKijunJikanHaisetsu(),
                entity.getKijunJikanIdo(), entity.getKijunJikanSeiketsuHoji(), entity.getKijunJikanKansetsuCare(),
                entity.getKijunJikanBPSDKanren(), entity.getKijunJikanKinoKunren(), entity.getKijunJikanIryoKanren(),
                entity.getKijunJikanNinchishoKasan(), entity.getKijunJikan()));
        項目.set前回要介護認定等基準時間(set要介護認定等基準時間(entity.getZKijunJikanShokuji(), entity.getZKijunJikanHaisetsu(),
                entity.getZKijunJikanIdo(), entity.getZKijunJikanSeiketsuHoji(), entity.getZKijunJikanKansetsuCare(),
                entity.getZKijunJikanBPSDKanren(), entity.getZKijunJikanKinoKunren(), entity.getZKijunJikanIryoKanren(),
                entity.getZKijunJikanNinchishoKasan(), entity.getZKijunJikan()));
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
        List<TyukanHyouka> 中間評価リスト = new ArrayList<>();
        TyukanHyouka 中間評価項目 = new TyukanHyouka();
        中間評価項目.set第1群(new RString(entity.getChukanHyokaKomoku1gun()));
        中間評価項目.set第2群(new RString(entity.getChukanHyokaKomoku2gun()));
        中間評価項目.set第3群(new RString(entity.getChukanHyokaKomoku3gun()));
        中間評価項目.set第4群(new RString(entity.getChukanHyokaKomoku4gun()));
        中間評価項目.set第5群(new RString(entity.getChukanHyokaKomoku5gun()));
        TyukanHyouka 前中間評価項目 = new TyukanHyouka();
        前中間評価項目.set第1群(new RString(entity.getZChukanHyokaKomoku1gun()));
        前中間評価項目.set第2群(new RString(entity.getZChukanHyokaKomoku2gun()));
        前中間評価項目.set第3群(new RString(entity.getZChukanHyokaKomoku3gun()));
        前中間評価項目.set第4群(new RString(entity.getZChukanHyokaKomoku4gun()));
        前中間評価項目.set第5群(new RString(entity.getZChukanHyokaKomoku5gun()));
        中間評価リスト.add(中間評価項目);
        中間評価リスト.add(前中間評価項目);
        項目.set中間評価リスト(中間評価リスト);
        List<NitijouSeikatsu> 日常生活自立度リスト = new ArrayList<>();
        NitijouSeikatsu 障害高齢者自立度 = new NitijouSeikatsu();
        障害高齢者自立度.set特記事項フラグ(entity.getShogaiNichijoSeikatsuJiritsudo());
        障害高齢者自立度.set認知症高齢者自立度(set障害高齢者自立度(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
        NitijouSeikatsu 認知症高齢者自立度 = new NitijouSeikatsu();
        認知症高齢者自立度.set特記事項フラグ(entity.getNinchishoNichijoSeikatsuJiritsudo());
        認知症高齢者自立度.set認知症高齢者自立度(set障害高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        日常生活自立度リスト.add(障害高齢者自立度);
        日常生活自立度リスト.add(認知症高齢者自立度);
        項目.set日常生活自立度リスト(日常生活自立度リスト);
        項目.set認定調査結果認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        項目.set意見書認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        settei.setサービスの状況(entity, 項目, 予防給付, 介護給付, サービス状況フラグ, 厚労省IF識別コード, 共通情報);

        return 項目;
    }

    private RString set有効期間(int 有効期間) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(有効期間)
                .append(月間);
        return builder.toRString();
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
        if (一次判定結果コード_認知症加算 != null && !一次判定結果コード_認知症加算.isEmpty()) {
            if (A_99.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun99.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun02.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun06.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun09.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            }
        }
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

    private RString set認知症高齢者自立度(Code 認知症高齢者自立度コード) {
        if (認知症高齢者自立度コード != null && !認知症高齢者自立度コード.isEmpty()) {
            NinchishoNichijoSeikatsuJiritsudoCode.toValue(認知症高齢者自立度コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private List<TiyosaKekka> get第１群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果) {
        List<TiyosaKekka> 第１群リスト = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get麻痺_左上肢(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get麻痺_右上肢(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get麻痺_左下肢(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get麻痺_右下肢(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get麻痺_その他(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get拘縮_肩関節(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get拘縮_股関節(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get拘縮_膝関節(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get拘縮_その他(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get寝返り(厚労省IF識別コード))) {
                調査結果 = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
                第１群.set調査結果(調査結果);
            }
            get第１群リスト１(厚労省IF識別コード, 調査票調査項目, 前回調査票調査項目, 第１群, is前回結果);
            第１群リスト.add(第１群);
        }
        return 第１群リスト;
    }

    private void get第１群リスト１(Code 厚労省IF識別コード, DbT5211NinteichosahyoChosaItemEntity 調査票調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 第１群,
            boolean is前回結果) {
        RString 調査結果;
        RString 調査結果コード;
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        if (new RString(調査票調査項目.getRemban()).equals(settei.get起き上(厚労省IF識別コード))) {
            調査結果 = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get座位保持(厚労省IF識別コード))) {
            調査結果 = ChosaAnser03.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser03.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get両足での立位(厚労省IF識別コード))) {
            調査結果 = ChosaAnser04.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser04.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get歩行(厚労省IF識別コード))) {
            調査結果 = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get立ち上(厚労省IF識別コード))) {
            調査結果 = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser02.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get片足での立位(厚労省IF識別コード))) {
            調査結果 = ChosaAnser04.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser04.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get洗身(厚労省IF識別コード))) {
            調査結果 = ChosaAnser06.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser06.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.getつめ切り(厚労省IF識別コード))) {
            調査結果 = ChosaAnser07.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser07.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get視力(厚労省IF識別コード))) {
            調査結果 = ChosaAnser08.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser08.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        } else if (new RString(調査票調査項目.getRemban()).equals(settei.get聴力(厚労省IF識別コード))) {
            調査結果 = ChosaAnser09.toValue(調査票調査項目.getResearchItem()).get名称();
            調査結果コード = ChosaAnser09.toValue(調査票調査項目.getResearchItem()).getコード();
            set前回結果(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第１群, is前回結果);
            第１群.set調査結果(調査結果);
        }
    }

    private void set前回結果(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 第１群,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get麻痺_左上肢(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get麻痺_右上肢(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get麻痺_左下肢(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get麻痺_右下肢(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get麻痺_その他(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get拘縮_肩関節(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get拘縮_股関節(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get拘縮_膝関節(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get拘縮_その他(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get寝返り(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set寝返起き上今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get起き上(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).getコード();
                第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set寝返起き上今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
            }
            set前回結果１(厚労省IF識別コード, 今回結果コード, 前回調査票調査, 第１群, is前回結果);
        }
    }

    private void set前回結果１(Code 厚労省IF識別コード, RString 今回結果コード,
            DbT5211NinteichosahyoChosaItemEntity 前回調査票調査, TiyosaKekka 第１群, boolean is前回結果) {
        RString 前回調査結果コード;
        RString 前回調査結果;
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        if (new RString(前回調査票調査.getRemban()).equals(settei.get座位保持(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser03.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser03.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set座位保持今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get両足での立位(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser04.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser04.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set両足での立位今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get歩行(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set寝返起き上今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get立ち上(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser02.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set寝返起き上今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get片足での立位(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser04.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser04.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set両足での立位今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get洗身(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser06.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser06.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set洗身今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.getつめ切り(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser07.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser07.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            setつめ切り今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get視力(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser08.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser08.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set視力今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        } else if (new RString(前回調査票調査.getRemban()).equals(settei.get聴力(厚労省IF識別コード))) {
            前回調査結果 = ChosaAnser09.toValue(前回調査票調査.getResearchItem()).get名称();
            前回調査結果コード = ChosaAnser09.toValue(前回調査票調査.getResearchItem()).getコード();
            第１群.set前回結果(get前回結果(is前回結果, 前回調査結果));
            set聴力今回結果前回結果比(今回結果コード, 前回調査結果コード, 第１群);
        }
    }

    private List<TiyosaKekka> get第２群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果) {
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第２群 = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get移乗(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get移動(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getえん下(厚労省IF識別コード))) {
                調査結果 = ChosaAnser11.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser11.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get食事摂取(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get排尿(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get排便(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get口腔清潔(厚労省IF識別コード))) {
                調査結果 = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get洗顔(厚労省IF識別コード))) {
                調査結果 = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get整髪(厚労省IF識別コード))) {
                調査結果 = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get上衣の着脱(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getズボン等の着脱(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get外出頻度(厚労省IF識別コード))) {
                調査結果 = ChosaAnser13.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser13.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第２群, is前回結果);
                第２群.set調査結果(調査結果);
            }
            第２群リスト.add(第２群);
        }
        return 第２群リスト;
    }

    private void set前回結果２(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 第２群,
            boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get移乗(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get移動(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getえん下(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser11.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser11.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                setえん下今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get食事摂取(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get排尿(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get排便(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get口腔清潔(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set口腔清潔今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get洗顔(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set口腔清潔今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get整髪(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set口腔清潔今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get上衣の着脱(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getズボン等の着脱(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get座位保持(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get外出頻度(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser13.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser13.toValue(前回調査票調査.getResearchItem()).getコード();
                第２群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set外出頻度今回結果前回結果比(今回結果コード, 前回調査結果コード, 第２群);
            }
        }
    }

    private List<TiyosaKekka> get第３群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果) {
        List<TiyosaKekka> 第３群リスト = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第３群 = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get意思の伝達(厚労省IF識別コード))) {
                調査結果 = ChosaAnser14.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser14.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get毎日の日課を理解(厚労省IF識別コード))) {
                調査結果 = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get生年月日(厚労省IF識別コード))) {
                調査結果 = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get短期記憶(厚労省IF識別コード))) {
                調査結果 = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get自分の名前(厚労省IF識別コード))) {
                調査結果 = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get今の季節を理解(厚労省IF識別コード))) {
                調査結果 = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get場所の理解(厚労省IF識別コード))) {
                調査結果 = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser15.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get徘徊(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get外出して戻(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果３(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第３群, is前回結果);
                第３群.set調査結果(調査結果);
            }
            第３群リスト.add(第３群);
        }
        return 第３群リスト;
    }

    private void set前回結果３(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 第３群, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get意思の伝達(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser14.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser14.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set意思の伝達今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get毎日の日課を理解(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set毎日の日課を理解今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get生年月日(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set毎日の日課を理解今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get短期記憶(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set毎日の日課を理解今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get自分の名前(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set毎日の日課を理解今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get今の季節を理解(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set毎日の日課を理解今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get場所の理解(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser15.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set毎日の日課を理解今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get徘徊(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get外出して戻(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第３群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第３群);
            }
        }
    }

    private List<TiyosaKekka> get第４群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果) {
        List<TiyosaKekka> 第４群リスト = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第４群 = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get被害的(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get作話(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get感情が不安定(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get昼夜逆転(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get同じ話をする(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get大声を出す(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get介護に抵抗(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get落ち着きなし(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get一人で出たがる(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get収集癖(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get物や衣類を壊す(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getひどい物忘れ(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get独り言独り笑い(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get自分勝手(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get話がまとまらない(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果４(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第４群, is前回結果);
                第４群.set調査結果(調査結果);
            }
            第４群リスト.add(第４群);
        }
        return 第４群リスト;
    }

    private void set前回結果４(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 第４群, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get被害的(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get作話(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get感情が不安定(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get昼夜逆転(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get同じ話をする(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get大声を出す(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get介護に抵抗(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get落ち着きなし(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get一人で出たがる(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get収集癖(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get物や衣類を壊す(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getひどい物忘れ(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get独り言独り笑い(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get自分勝手(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get話がまとまらない(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第４群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第４群);
            }
        }
    }

    private List<TiyosaKekka> get第５群リスト(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, boolean is前回結果) {
        List<TiyosaKekka> 第５群リスト = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 第５群 = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get薬の内服(厚労省IF識別コード))) {
                調査結果 = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果５(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第５群, is前回結果);
                第５群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get金銭の管理(厚労省IF識別コード))) {
                調査結果 = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser12.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果５(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第５群, is前回結果);
                第５群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get日常の意思決定(厚労省IF識別コード))) {
                調査結果 = ChosaAnser17.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser17.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果５(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第５群, is前回結果);
                第５群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get集団への不適応(厚労省IF識別コード))) {
                調査結果 = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser16.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果５(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第５群, is前回結果);
                第５群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get買い物(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果５(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第５群, is前回結果);
                第５群.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get簡単な調理(厚労省IF識別コード))) {
                調査結果 = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser10.toValue(調査票調査項目.getResearchItem()).getコード();
                set前回結果５(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 第５群, is前回結果);
                第５群.set調査結果(調査結果);
            }
            第５群リスト.add(第５群);
        }
        return 第５群リスト;
    }

    private void set前回結果５(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 第５群, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get薬の内服(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set口腔清潔今回結果前回結果比(今回結果コード, 前回調査結果コード, 第５群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get金銭の管理(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser12.toValue(前回調査票調査.getResearchItem()).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set口腔清潔今回結果前回結果比(今回結果コード, 前回調査結果コード, 第５群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get日常の意思決定(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser17.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser17.toValue(前回調査票調査.getResearchItem()).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set日常の意思決定今回結果前回結果比(今回結果コード, 前回調査結果コード, 第５群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get集団への不適応(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser16.toValue(前回調査票調査.getResearchItem()).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set徘徊今回結果前回結果比(今回結果コード, 前回調査結果コード, 第５群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get買い物(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第５群);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get簡単な調理(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser10.toValue(前回調査票調査.getResearchItem()).getコード();
                第５群.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set移乗今回結果前回結果比(今回結果コード, 前回調査結果コード, 第５群);
            }
        }
    }

    private List<TiyosaKekka> get特別な医療リスト１(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目) {
        List<TiyosaKekka> 特別な医療リスト１ = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 特別な医療１ = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get点滴の管理(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療１(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療１);
                特別な医療１.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get中心静脈栄養(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療１(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療１);
                特別な医療１.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get透析(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療１(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療１);
                特別な医療１.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getストーマの処置(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療１(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療１);
                特別な医療１.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get酸素療法(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療１(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療１);
                特別な医療１.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getレスピレーター(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療１(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療１);
                特別な医療１.set調査結果(調査結果);
            }
            特別な医療リスト１.add(特別な医療１);
        }
        return 特別な医療リスト１;
    }

    private void set特別な医療１(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 特別な医療１) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get点滴の管理(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療１.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療１);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get中心静脈栄養(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療１.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療１);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get透析(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療１.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療１);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getストーマの処置(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療１.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療１);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get酸素療法(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療１.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療１);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getレスピレーター(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療１.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療１);
            }
        }
    }

    private List<TiyosaKekka> get特別な医療リスト２(Code 厚労省IF識別コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目) {
        List<TiyosaKekka> 特別な医療リスト２ = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 調査票調査項目 : 調査票調査項目情報) {
            TiyosaKekka 特別な医療２ = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(調査票調査項目.getRemban()).equals(settei.get気管切開の処置(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療２);
                特別な医療２.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get疼痛の看護(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療２);
                特別な医療２.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.get経管栄養(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療２);
                特別な医療２.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getモニター測定(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療２);
                特別な医療２.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getじょくそうの処置(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療２);
                特別な医療２.set調査結果(調査結果);
            } else if (new RString(調査票調査項目.getRemban()).equals(settei.getカテーテル(厚労省IF識別コード))) {
                調査結果 = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).get名称();
                調査結果コード = ChosaAnser01.toValue(調査票調査項目.getResearchItem()).getコード();
                set特別な医療２(厚労省IF識別コード, 調査結果コード, 前回調査票調査項目, 特別な医療２);
                特別な医療２.set調査結果(調査結果);
            }
            特別な医療リスト２.add(特別な医療２);
        }
        return 特別な医療リスト２;
    }

    private void set特別な医療２(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目, TiyosaKekka 特別な医療２) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity 前回調査票調査 : 前回調査票調査項目) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前回調査票調査.getRemban()).equals(settei.get気管切開の処置(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療２.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療２);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get疼痛の看護(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療２.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療２);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.get経管栄養(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療２.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療２);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getモニター測定(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療２.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療２);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getじょくそうの処置(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療２.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療２);
            } else if (new RString(前回調査票調査.getRemban()).equals(settei.getカテーテル(厚労省IF識別コード))) {
                前回調査結果 = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).get名称();
                前回調査結果コード = ChosaAnser01.toValue(前回調査票調査.getResearchItem()).getコード();
                特別な医療２.set前回結果(前回調査結果);
                set麻痺今回結果前回結果比(今回結果コード, 前回調査結果コード, 特別な医療２);
            }
        }
    }

    private List<TiyosaKekka> get主治医意見書リスト(Code 厚労省IF識別コード,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, boolean is前回結果) {
        List<TiyosaKekka> 主治医意見書リスト = new ArrayList<>();
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書項目 : 主治医意見書項目情報) {
            TiyosaKekka 主治医意見書 = new TiyosaKekka();
            RString 調査結果;
            RString 調査結果コード;
            if (new RString(主治医意見書項目.getRemban()).equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                調査結果 = IkenKomoku03.toValue(主治医意見書項目.getIkenItem()).get名称();
                調査結果コード = IkenKomoku03.toValue(主治医意見書項目.getIkenItem()).getコード();
                set主治医意見書(厚労省IF識別コード, 調査結果コード, 前主治医意見書項目情報, 主治医意見書, is前回結果);
                主治医意見書.set調査結果(調査結果);
            } else if (new RString(主治医意見書項目.getRemban()).equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                調査結果 = IkenKomoku04.toValue(主治医意見書項目.getIkenItem()).get名称();
                調査結果コード = IkenKomoku04.toValue(主治医意見書項目.getIkenItem()).getコード();
                set主治医意見書(厚労省IF識別コード, 調査結果コード, 前主治医意見書項目情報, 主治医意見書, is前回結果);
                主治医意見書.set調査結果(調査結果);
            } else if (new RString(主治医意見書項目.getRemban()).equals(settei.get認知能力(厚労省IF識別コード))) {
                調査結果 = IkenKomoku05.toValue(主治医意見書項目.getIkenItem()).get名称();
                調査結果コード = IkenKomoku05.toValue(主治医意見書項目.getIkenItem()).getコード();
                set主治医意見書(厚労省IF識別コード, 調査結果コード, 前主治医意見書項目情報, 主治医意見書, is前回結果);
                主治医意見書.set調査結果(調査結果);
            } else if (new RString(主治医意見書項目.getRemban()).equals(settei.get伝達能力(厚労省IF識別コード))) {
                調査結果 = IkenKomoku06.toValue(主治医意見書項目.getIkenItem()).get名称();
                調査結果コード = IkenKomoku06.toValue(主治医意見書項目.getIkenItem()).getコード();
                set主治医意見書(厚労省IF識別コード, 調査結果コード, 前主治医意見書項目情報, 主治医意見書, is前回結果);
                主治医意見書.set調査結果(調査結果);
            } else if (new RString(主治医意見書項目.getRemban()).equals(settei.get食事行為(厚労省IF識別コード))) {
                調査結果 = IkenKomoku14.toValue(主治医意見書項目.getIkenItem()).get名称();
                調査結果コード = IkenKomoku14.toValue(主治医意見書項目.getIkenItem()).getコード();
                set主治医意見書(厚労省IF識別コード, 調査結果コード, 前主治医意見書項目情報, 主治医意見書, is前回結果);
                主治医意見書.set調査結果(調査結果);
            }
            主治医意見書リスト.add(主治医意見書);
        }
        return 主治医意見書リスト;
    }

    private void set主治医意見書(Code 厚労省IF識別コード, RString 今回結果コード,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前主治医意見書項目情報, TiyosaKekka 主治医意見書, boolean is前回結果) {
        IchijihanteikekkahyoItemSetteiThree settei = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5304ShujiiIkenshoIkenItemEntity 前主治医意見書項目 : 前主治医意見書項目情報) {
            RString 前回調査結果コード;
            RString 前回調査結果;
            if (new RString(前主治医意見書項目.getRemban()).equals(settei.get日常生活自立度(厚労省IF識別コード))) {
                前回調査結果 = IkenKomoku03.toValue(前主治医意見書項目.getIkenItem()).get名称();
                前回調査結果コード = IkenKomoku03.toValue(前主治医意見書項目.getIkenItem()).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set日常生活自立度今回結果前回結果比(今回結果コード, 前回調査結果コード, 主治医意見書);
            } else if (new RString(前主治医意見書項目.getRemban()).equals(settei.get短期記憶意見書(厚労省IF識別コード))) {
                前回調査結果 = IkenKomoku04.toValue(前主治医意見書項目.getIkenItem()).get名称();
                前回調査結果コード = IkenKomoku04.toValue(前主治医意見書項目.getIkenItem()).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set短期記憶意見書今回結果前回結果比(今回結果コード, 前回調査結果コード, 主治医意見書);
            } else if (new RString(前主治医意見書項目.getRemban()).equals(settei.get認知能力(厚労省IF識別コード))) {
                前回調査結果 = IkenKomoku05.toValue(前主治医意見書項目.getIkenItem()).get名称();
                前回調査結果コード = IkenKomoku05.toValue(前主治医意見書項目.getIkenItem()).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set認知能力今回結果前回結果比(今回結果コード, 前回調査結果コード, 主治医意見書);
            } else if (new RString(前主治医意見書項目.getRemban()).equals(settei.get伝達能力(厚労省IF識別コード))) {
                前回調査結果 = IkenKomoku06.toValue(前主治医意見書項目.getIkenItem()).get名称();
                前回調査結果コード = IkenKomoku06.toValue(前主治医意見書項目.getIkenItem()).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set伝達能力今回結果前回結果比(今回結果コード, 前回調査結果コード, 主治医意見書);
            } else if (new RString(前主治医意見書項目.getRemban()).equals(settei.get食事行為(厚労省IF識別コード))) {
                前回調査結果 = IkenKomoku14.toValue(前主治医意見書項目.getIkenItem()).get名称();
                前回調査結果コード = IkenKomoku14.toValue(前主治医意見書項目.getIkenItem()).getコード();
                主治医意見書.set前回結果(get前回結果(is前回結果, 前回調査結果));
                set食事行為今回結果前回結果比(今回結果コード, 前回調査結果コード, 主治医意見書);
            }
        }
    }

    private void set麻痺今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if (ChosaAnser01.あり.getコード().equals(今回結果コード) && ChosaAnser01.なし.getコード().equals(前回調査結果コード)) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if (ChosaAnser01.あり.getコード().equals(前回調査結果コード) && ChosaAnser01.なし.getコード().equals(今回結果コード)) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private void set寝返起き上今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser02.できない.getコード().equals(今回結果コード) && (ChosaAnser02.つかまらないでできる.getコード().equals(前回調査結果コード)
                || ChosaAnser02.何かにつかまればできる.getコード().equals(前回調査結果コード))) || (ChosaAnser02.何かにつかまればできる.getコード().equals(今回結果コード)
                && ChosaAnser02.つかまらないでできる.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser02.できない.getコード().equals(前回調査結果コード) && (ChosaAnser02.つかまらないでできる.getコード().equals(今回結果コード)
                || ChosaAnser02.何かにつかまればできる.getコード().equals(今回結果コード))) || (ChosaAnser02.何かにつかまればできる.getコード().equals(前回調査結果コード)
                && ChosaAnser02.つかまらないでできる.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private void set座位保持今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser03.できない.getコード().equals(今回結果コード) && (ChosaAnser03.支えが必要.getコード().equals(前回調査結果コード)
                || ChosaAnser03.自分で支えれば可.getコード().equals(前回調査結果コード) || ChosaAnser03.できる.getコード().equals(前回調査結果コード)))
                || (ChosaAnser03.支えが必要.getコード().equals(今回結果コード) && (ChosaAnser03.自分で支えれば可.getコード().equals(前回調査結果コード)
                || ChosaAnser03.できる.getコード().equals(前回調査結果コード))) || (ChosaAnser03.自分で支えれば可.getコード().equals(今回結果コード)
                && ChosaAnser03.できる.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser03.できない.getコード().equals(前回調査結果コード) && (ChosaAnser03.支えが必要.getコード().equals(今回結果コード)
                || ChosaAnser03.自分で支えれば可.getコード().equals(今回結果コード) || ChosaAnser03.できる.getコード().equals(今回結果コード)))
                || (ChosaAnser03.支えが必要.getコード().equals(前回調査結果コード) && (ChosaAnser03.自分で支えれば可.getコード().equals(今回結果コード)
                || ChosaAnser03.できる.getコード().equals(今回結果コード))) || (ChosaAnser03.自分で支えれば可.getコード().equals(前回調査結果コード)
                && ChosaAnser03.できる.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private void set両足での立位今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser04.できない.getコード().equals(今回結果コード) && (ChosaAnser04.何か支えがあればできる.getコード().equals(前回調査結果コード)
                || ChosaAnser04.支えなしでできる.getコード().equals(前回調査結果コード))) || (ChosaAnser04.何か支えがあればできる.getコード().equals(今回結果コード)
                && ChosaAnser04.支えなしでできる.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser04.できない.getコード().equals(前回調査結果コード) && (ChosaAnser04.何か支えがあればできる.getコード().equals(今回結果コード)
                || ChosaAnser04.支えなしでできる.getコード().equals(今回結果コード))) || (ChosaAnser04.何か支えがあればできる.getコード().equals(前回調査結果コード)
                && ChosaAnser04.支えなしでできる.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private void set洗身今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser06.行っていない.getコード().equals(今回結果コード) && (ChosaAnser06.全介助.getコード().equals(前回調査結果コード)
                || ChosaAnser06.一部介助.getコード().equals(前回調査結果コード) || ChosaAnser06.介助されていない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser06.全介助.getコード().equals(今回結果コード) && (ChosaAnser06.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser06.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser06.一部介助.getコード().equals(今回結果コード)
                && ChosaAnser06.介助されていない.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser06.行っていない.getコード().equals(前回調査結果コード) && (ChosaAnser06.全介助.getコード().equals(今回結果コード)
                || ChosaAnser06.一部介助.getコード().equals(今回結果コード) || ChosaAnser06.介助されていない.getコード().equals(今回結果コード)))
                || (ChosaAnser06.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser06.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser06.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser06.一部介助.getコード().equals(前回調査結果コード)
                && ChosaAnser06.介助されていない.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private void setつめ切り今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser07.全介助.getコード().equals(今回結果コード) && (ChosaAnser07.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser07.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser07.一部介助.getコード().equals(今回結果コード)
                && ChosaAnser07.介助されていない.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser07.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser07.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser07.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser07.一部介助.getコード().equals(前回調査結果コード)
                && ChosaAnser07.介助されていない.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private void set視力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser08.見えているのか判断不能.getコード().equals(今回結果コード) && (ChosaAnser08.ほとんど見えない.getコード().equals(前回調査結果コード)
                || ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(前回調査結果コード) || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード)
                || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード))) || is視力今回前回結果比１(今回結果コード, 前回調査結果コード, 第１群)) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser08.見えているのか判断不能.getコード().equals(前回調査結果コード) && (ChosaAnser08.ほとんど見えない.getコード().equals(今回結果コード)
                || ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(今回結果コード) || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード)
                || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード))) || is視力前回今回結果比１(今回結果コード, 前回調査結果コード, 第１群)) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private boolean is視力今回前回結果比１(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        boolean is今回前回結果 = false;
        if ((ChosaAnser08.ほとんど見えない.getコード().equals(今回結果コード) && (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(前回調査結果コード)
                || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード) || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(今回結果コード)
                && (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード) || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード) && ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is視力前回今回結果比１(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        boolean is前回今回結果 = false;
        if ((ChosaAnser08.ほとんど見えない.getコード().equals(前回調査結果コード) && (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(今回結果コード)
                || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード) || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード)))
                || (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(前回調査結果コード) && (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード)
                || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード))) || (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード)
                && ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;
    }

    private void set聴力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser09.聞こえているのか判断不能.getコード().equals(今回結果コード) && (ChosaAnser09.ほとんど聞こえない.getコード().equals(前回調査結果コード)
                || ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(前回調査結果コード) || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード)
                || ChosaAnser09.普通.getコード().equals(前回調査結果コード))) || is聴力今回前回結果比１(今回結果コード, 前回調査結果コード, 第１群)) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser09.聞こえているのか判断不能.getコード().equals(前回調査結果コード) && (ChosaAnser09.ほとんど聞こえない.getコード().equals(今回結果コード)
                || ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(今回結果コード) || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード)
                || ChosaAnser09.普通.getコード().equals(今回結果コード))) || is聴力前回今回結果比１(今回結果コード, 前回調査結果コード, 第１群)) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private boolean is聴力今回前回結果比１(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        boolean is今回前回結果 = false;
        if ((ChosaAnser09.ほとんど聞こえない.getコード().equals(今回結果コード) && (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(前回調査結果コード)
                || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード) || ChosaAnser09.普通.getコード().equals(前回調査結果コード)))
                || (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(今回結果コード) && (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード)
                || ChosaAnser09.普通.getコード().equals(前回調査結果コード))) || (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード)
                && ChosaAnser09.普通.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is聴力前回今回結果比１(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        boolean is前回今回結果 = false;
        if ((ChosaAnser09.ほとんど聞こえない.getコード().equals(前回調査結果コード) && (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(今回結果コード)
                || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード) || ChosaAnser09.普通.getコード().equals(今回結果コード)))
                || (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(前回調査結果コード) && (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード)
                || ChosaAnser09.普通.getコード().equals(今回結果コード))) || (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード)
                && ChosaAnser09.普通.getコード().equals(今回結果コード))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;
    }

    private void set移乗今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser10.全介助.getコード().equals(今回結果コード) && (ChosaAnser10.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser10.見守り等.getコード().equals(前回調査結果コード) || ChosaAnser10.介助されていない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser10.一部介助.getコード().equals(今回結果コード) && (ChosaAnser10.見守り等.getコード().equals(前回調査結果コード)
                || ChosaAnser10.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser10.見守り等.getコード().equals(今回結果コード)
                && ChosaAnser10.介助されていない.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser10.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser10.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser10.見守り等.getコード().equals(今回結果コード) || ChosaAnser10.介助されていない.getコード().equals(今回結果コード)))
                || (ChosaAnser10.一部介助.getコード().equals(前回調査結果コード) && (ChosaAnser10.見守り等.getコード().equals(今回結果コード)
                || ChosaAnser10.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser10.見守り等.getコード().equals(前回調査結果コード)
                && ChosaAnser10.介助されていない.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void setえん下今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser11.できない.getコード().equals(今回結果コード) && (ChosaAnser11.見守り等.getコード().equals(前回調査結果コード)
                || ChosaAnser11.できる.getコード().equals(前回調査結果コード))) || (ChosaAnser11.見守り等.getコード().equals(今回結果コード)
                && ChosaAnser11.できる.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser11.できない.getコード().equals(前回調査結果コード) && (ChosaAnser11.見守り等.getコード().equals(今回結果コード)
                || ChosaAnser11.できる.getコード().equals(今回結果コード))) || (ChosaAnser11.見守り等.getコード().equals(前回調査結果コード)
                && ChosaAnser11.できる.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void set口腔清潔今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser12.全介助.getコード().equals(今回結果コード) && (ChosaAnser12.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser12.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser12.一部介助.getコード().equals(今回結果コード)
                && ChosaAnser12.介助されていない.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser12.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser12.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser12.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser12.一部介助.getコード().equals(前回調査結果コード)
                && ChosaAnser12.介助されていない.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void set外出頻度今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser13.月1回未満.getコード().equals(今回結果コード) && (ChosaAnser13.月1回以上.getコード().equals(前回調査結果コード)
                || ChosaAnser13.週1回以上.getコード().equals(前回調査結果コード))) || (ChosaAnser13.月1回以上.getコード().equals(今回結果コード)
                && ChosaAnser13.週1回以上.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser13.月1回未満.getコード().equals(前回調査結果コード) && (ChosaAnser13.月1回以上.getコード().equals(今回結果コード)
                || ChosaAnser13.週1回以上.getコード().equals(今回結果コード))) || (ChosaAnser13.月1回以上.getコード().equals(前回調査結果コード)
                && ChosaAnser13.週1回以上.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void set意思の伝達今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if ((ChosaAnser14.できない.getコード().equals(今回結果コード) && (ChosaAnser14.ほとんど伝達できない.getコード().equals(前回調査結果コード)
                || ChosaAnser14.ときどき伝達できる.getコード().equals(前回調査結果コード) || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(前回調査結果コード)))
                || (ChosaAnser14.ほとんど伝達できない.getコード().equals(今回結果コード) && (ChosaAnser14.ときどき伝達できる.getコード().equals(前回調査結果コード)
                || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(前回調査結果コード))) || (ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード)
                && ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(前回調査結果コード))) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser14.できない.getコード().equals(前回調査結果コード) && (ChosaAnser14.ほとんど伝達できない.getコード().equals(今回結果コード)
                || ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード) || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード)))
                || (ChosaAnser14.ほとんど伝達できない.getコード().equals(前回調査結果コード) && (ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード)
                || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) || (ChosaAnser14.ときどき伝達できる.getコード().equals(前回調査結果コード)
                && ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    private void set毎日の日課を理解今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if (ChosaAnser15.できない.getコード().equals(今回結果コード) && ChosaAnser15.できる.getコード().equals(前回調査結果コード)) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if (ChosaAnser15.できない.getコード().equals(前回調査結果コード) && ChosaAnser15.できる.getコード().equals(今回結果コード)) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    private void set徘徊今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if ((ChosaAnser16.ある.getコード().equals(今回結果コード) && (ChosaAnser16.ときどきある.getコード().equals(前回調査結果コード)
                || ChosaAnser16.ない.getコード().equals(前回調査結果コード))) || (ChosaAnser16.ときどきある.getコード().equals(今回結果コード)
                && ChosaAnser16.ない.getコード().equals(前回調査結果コード))) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser16.ある.getコード().equals(前回調査結果コード) && (ChosaAnser16.ときどきある.getコード().equals(今回結果コード)
                || ChosaAnser16.ない.getコード().equals(今回結果コード))) || (ChosaAnser16.ときどきある.getコード().equals(前回調査結果コード)
                && ChosaAnser16.ない.getコード().equals(今回結果コード))) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    private void set日常の意思決定今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if ((ChosaAnser17.できない.getコード().equals(今回結果コード) && (ChosaAnser17.日常的に困難.getコード().equals(前回調査結果コード)
                || ChosaAnser17.特別な場合を除いてできる.getコード().equals(前回調査結果コード) || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(前回調査結果コード)))
                || (ChosaAnser17.日常的に困難.getコード().equals(今回結果コード) && (ChosaAnser17.特別な場合を除いてできる.getコード().equals(前回調査結果コード)
                || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(前回調査結果コード))) || (ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード)
                && ChosaAnser17.できる_特別な場合でもできる.getコード().equals(前回調査結果コード))) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser17.できない.getコード().equals(前回調査結果コード) && (ChosaAnser17.日常的に困難.getコード().equals(今回結果コード)
                || ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード) || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード)))
                || (ChosaAnser17.日常的に困難.getコード().equals(前回調査結果コード) && (ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード)
                || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード))) || (ChosaAnser17.特別な場合を除いてできる.getコード().equals(前回調査結果コード)
                && ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード))) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    private void set日常生活自立度今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if (is日常生活自立度今回前回比１(今回結果コード, 前回調査結果コード, 第２群) || is日常生活自立度今回前回比２(今回結果コード, 前回調査結果コード, 第２群)
                || is日常生活自立度今回前回比３(今回結果コード, 前回調査結果コード, 第２群) || is日常生活自立度今回前回比４(今回結果コード, 前回調査結果コード, 第２群)) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if (is日常生活自立度前回今回比１(今回結果コード, 前回調査結果コード, 第２群) || is日常生活自立度前回今回比２(今回結果コード, 前回調査結果コード, 第２群)
                || is日常生活自立度前回今回比３(今回結果コード, 前回調査結果コード, 第２群) || is日常生活自立度前回今回比４(今回結果コード, 前回調査結果コード, 第２群)) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private boolean is日常生活自立度今回前回比１(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is今回前回結果 = false;
        if (IkenKomoku03.M.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅳ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅲb.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード) || IkenKomoku03.自立.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度今回前回比２(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is今回前回結果 = false;
        if (IkenKomoku03.Ⅳ.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅲb.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.自立.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度今回前回比３(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is今回前回結果 = false;
        if ((IkenKomoku03.Ⅲb.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード) || IkenKomoku03.自立.getコード().equals(前回調査結果コード)))
                || (IkenKomoku03.Ⅲa.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.自立.getコード().equals(前回調査結果コード)))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度今回前回比４(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is今回前回結果 = false;
        if ((IkenKomoku03.Ⅱb.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード) || IkenKomoku03.自立.getコード().equals(前回調査結果コード)))
                || (IkenKomoku03.Ⅱa.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.自立.getコード().equals(前回調査結果コード))) || (IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                && IkenKomoku03.自立.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度前回今回比１(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.M.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅳ.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅲb.getコード().equals(今回結果コード) || IkenKomoku03.Ⅲa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(今回結果コード) || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード) || IkenKomoku03.自立.getコード().equals(今回結果コード)))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private boolean is日常生活自立度前回今回比２(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.Ⅳ.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅲb.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅲa.getコード().equals(今回結果コード) || IkenKomoku03.Ⅱb.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード) || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                || IkenKomoku03.自立.getコード().equals(今回結果コード)))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private boolean is日常生活自立度前回今回比３(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.Ⅲb.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅲa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(今回結果コード) || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード) || IkenKomoku03.自立.getコード().equals(今回結果コード)))
                || (IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅱb.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード) || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                || IkenKomoku03.自立.getコード().equals(今回結果コード)))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private boolean is日常生活自立度前回今回比４(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅱa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード) || IkenKomoku03.自立.getコード().equals(今回結果コード)))
                || (IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                || IkenKomoku03.自立.getコード().equals(今回結果コード))) || (IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                && IkenKomoku03.自立.getコード().equals(今回結果コード))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private void set短期記憶意見書今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku04.問題あり.getコード().equals(今回結果コード) && IkenKomoku04.問題なし.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku04.問題あり.getコード().equals(前回調査結果コード) && IkenKomoku04.問題なし.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void set認知能力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku05.判断できない.getコード().equals(今回結果コード) && (IkenKomoku05.見守りが必要.getコード().equals(前回調査結果コード)
                || IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード) || IkenKomoku05.自立.getコード().equals(前回調査結果コード)))
                || (IkenKomoku05.見守りが必要.getコード().equals(今回結果コード) && (IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード)
                || IkenKomoku05.自立.getコード().equals(前回調査結果コード))) || (IkenKomoku05.いくらか困難.getコード().equals(今回結果コード)
                && IkenKomoku05.自立.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku05.判断できない.getコード().equals(前回調査結果コード) && (IkenKomoku05.見守りが必要.getコード().equals(今回結果コード)
                || IkenKomoku05.いくらか困難.getコード().equals(今回結果コード) || IkenKomoku05.自立.getコード().equals(今回結果コード)))
                || (IkenKomoku05.見守りが必要.getコード().equals(前回調査結果コード) && (IkenKomoku05.いくらか困難.getコード().equals(今回結果コード)
                || IkenKomoku05.自立.getコード().equals(今回結果コード))) || (IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード)
                && IkenKomoku05.自立.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void set伝達能力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku06.伝えられない.getコード().equals(今回結果コード) && (IkenKomoku06.具体的要求に限られる.getコード().equals(前回調査結果コード)
                || IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード) || IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード)))
                || (IkenKomoku06.具体的要求に限られる.getコード().equals(今回結果コード) && (IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード)
                || IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) || (IkenKomoku06.いくらか困難.getコード().equals(今回結果コード)
                && IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku06.伝えられない.getコード().equals(前回調査結果コード) && (IkenKomoku06.具体的要求に限られる.getコード().equals(今回結果コード)
                || IkenKomoku06.いくらか困難.getコード().equals(今回結果コード) || IkenKomoku06.伝えられる.getコード().equals(今回結果コード)))
                || (IkenKomoku06.具体的要求に限られる.getコード().equals(前回調査結果コード) && (IkenKomoku06.いくらか困難.getコード().equals(今回結果コード)
                || IkenKomoku06.伝えられる.getコード().equals(今回結果コード))) || (IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード)
                && IkenKomoku06.伝えられる.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private void set食事行為今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku14.全面介助.getコード().equals(今回結果コード) && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku14.全面介助.getコード().equals(前回調査結果コード) && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private RString get前回結果(boolean is前回結果, RString 前回調査結果) {
        if (is前回結果) {
            return 前回調査結果;
        }
        return RString.EMPTY;
    }

    private void コード転換(IchijihanteikekkahyoA3Entity 項目, ItiziHanteiEntity entity) {
        if (RString.isNullOrEmpty(entity.getHihokenshaKubunCode())) {
            項目.set被保険者区分(RString.EMPTY);
        } else {
            項目.set被保険者区分(HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称());
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
        if (entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty()) {
            項目.set特定疾病名(RString.EMPTY);
        } else {
            項目.set特定疾病名(TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode().getColumnValue()).get名称());
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
}
