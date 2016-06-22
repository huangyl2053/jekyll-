/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.publicationshiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoItem;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 委員用一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IchijihanteikekkahyoItemSettei {

    private static final RString 出力スタイル_A4 = new RString("1");
    private static final RString 月間 = new RString("月間");
    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");
    private static final RString 特記事項有 = new RString("＊");
    private static final RString 印字する = new RString("1");
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;
    private static final int 連番_3 = 3;
    private static final int 連番_4 = 4;
    private static final int 連番_5 = 5;
    private static final int 連番_6 = 6;
    private static final int 連番_7 = 7;
    private static final int 連番_8 = 8;
    private static final int 連番_9 = 9;
    private static final int 連番_10 = 10;
    private static final int 連番_11 = 11;
    private static final int 連番_12 = 12;
    private static final int 連番_13 = 13;
    private static final int 連番_14 = 14;
    private static final int 連番_15 = 15;
    private static final int 連番_16 = 16;
    private static final int 連番_17 = 17;
    private static final int 連番_18 = 18;
    private static final int 連番_19 = 19;
    private static final int 連番_20 = 20;

    /**
     * 委員用一次判定結果票Entityの設定。
     *
     * @param entity ItiziHanteiEntity
     * @param 特記事項情報 List<NinteichosahyoTokkijikoEntity>
     * @param paramter IinTokkiJikouItiziHanteiProcessParameter
     * @param itiziHanteiEntityList List<ItiziHanteiEntity>
     * @return 委員用一次判定結果票のEntity
     */
    public IchijihanteikekkahyoItem set項目(ItiziHanteiEntity entity, List<NinteichosahyoTokkijikoEntity> 特記事項情報,
            IinTokkiJikouItiziHanteiProcessParameter paramter, List<ItiziHanteiEntity> itiziHanteiEntityList) {
        IchijihanteikekkahyoItem item = new IchijihanteikekkahyoItem();
        IchijihanteikekkahyoItemSetteiTwo itemSetteiTwo = new IchijihanteikekkahyoItemSetteiTwo();
        RString 厚労省IF識別コード = entity.getDbt5101_koroshoIfShikibetsuCode().getColumnValue();

        item.set申請書管理番号(entity.getDbt5502_shinseishoKanriNo().getColumnValue());
        item.set帳票名(new RString("認定情報　（事務局用）"));
        item.set審査会審査順(new RString(entity.getDbt5502_shinsakaiOrder()));
        // TODO 不知道怎么做
        item.set現在の状況(GenzainoJokyoCode.toValue(出力スタイル_A4).get名称());
        item.set審査人数(new RString(entity.getDbt5502_shinsakaiOrder()));
        item.set合議体番号(paramter.getGogitaiNo());
        item.set被保険者区分(HihokenshaKubunCode.toValue(entity.getDbt5101_hihokenshaKubunCode()).get名称());
        item.set年齢(new RString(entity.getDbt5101_age()));
        // TODO QA
//        item.set前々回要介護度(YokaigoJotaiKubun09.toValue(entity.getDbt5101_zenYokaigoKubunCode().getColumnValue()).get名称());
//        item.set前々回認定有効期間(前々回認定有効期間(entity.getDbt5101_zenkaiYukoKikanStart(), entity.getDbt5101_zenkaiYukoKikanEnd()));
//        item.set前々回認定有効期間開始年月日(パターン17(entity.getDbt5101_zenkaiYukoKikanStart()));
//        item.set前々回認定有効期間終了年月日(パターン17(entity.getDbt5101_zenkaiYukoKikanEnd()));
        item.set前回認定有効期間(前々回認定有効期間(entity.getDbt5101_zenkaiYukoKikanStart(), entity.getDbt5101_zenkaiYukoKikanEnd()));
        item.set前回認定有効期間開始年月日(パターン17(entity.getDbt5101_zenkaiYukoKikanStart()));
        item.set前回認定有効期間終了年月日(パターン17(entity.getDbt5101_zenkaiYukoKikanEnd()));
        item.set前回認定日(パターン16(entity.getDbt5101_zenkaiNinteiYMD()));
        item.set審査会資料作成年月日(FlexibleDate.getNowDate());
        item.set今回認定申請年月日(entity.getDbt5101_ninteiShinseiYMD());
        item.set今回認定調査実施年月日(entity.getDbt5202_ninteichosaJisshiYMD());
        item.set今回認定審査年月日(entity.getDbt5502_shinsakaiKaisaiYMD());

        if (HihokenshaKubunCode.第１号被保険者.getコード().equals(entity.getDbt5101_hihokenshaKubunCode())) {
            item.set特定疾病名(RString.EMPTY);
        } else if (HihokenshaKubunCode.第２号被保険者.getコード().equals(entity.getDbt5101_hihokenshaKubunCode())) {
            item.set特定疾病名(TokuteiShippei.toValue(entity.getDbt5101_nigoTokuteiShippeiCode().getColumnValue()).get名称());
        }
        item.set要介護認定等基準時間(new RString(entity.getDbt5116_kijunJikan()));
        item.set要介護認定等基準時間_食事(new RString(entity.getDbt5116_kijunJikanShokuji()));
        item.set要介護認定等基準時間_排泄(new RString(entity.getDbt5116_kijunJikanHaisetsu()));
        item.set要介護認定等基準時間_移動(new RString(entity.getDbt5116_kijunJikanIdo()));
        item.set要介護認定等基準時間_清潔保持(new RString(entity.getDbt5116_kijunJikanSeiketsuHoji()));
        item.set要介護認定等基準時間_間接(new RString(entity.getDbt5116_kijunJikanKansetsuCare()));
        item.set要介護認定等基準時間_BPSD関連(new RString(entity.getDbt5116_kijunJikanBPSDKanren()));
        item.set要介護認定等基準時間_機能訓練(new RString(entity.getDbt5116_kijunJikanKinoKunren()));
        item.set要介護認定等基準時間_医療関連(new RString(entity.getDbt5116_kijunJikanIryoKanren()));
        item.set要介護認定等基準時間_認知症加算(new RString(entity.getDbt5116_kijunJikanNinchishoKasan()));
        item.set警告コード(entity.getDbt5116_ichijiHnateiKeikokuCode());
        item.set中間評価項目得点表第1群(new RString(entity.getDbt5116_chukanHyokaKomoku1gun()));
        item.set中間評価項目得点表第2群(new RString(entity.getDbt5116_chukanHyokaKomoku2gun()));
        item.set中間評価項目得点表第3群(new RString(entity.getDbt5116_chukanHyokaKomoku3gun()));
        item.set中間評価項目得点表第4群(new RString(entity.getDbt5116_chukanHyokaKomoku4gun()));
        item.set中間評価項目得点表第5群(new RString(entity.getDbt5116_chukanHyokaKomoku5gun()));
        // TODO QA
//        item.set前回中間評価項目得点表第1群(月間);
//        item.set前回中間評価項目得点表第2群(月間);
//        item.set前回中間評価項目得点表第3群(月間);
//        item.set前回中間評価項目得点表第4群(出力スタイル_A4);
//        item.set前回中間評価項目得点表第5群(月間);
        item.set障害高齢者自立度_ある(get障害高齢者自立度_ある(厚労省IF識別コード, 特記事項情報));
        item.set認知症高齢者自立度_ある(get認知症高齢者自立度_ある(厚労省IF識別コード, 特記事項情報));
        item.set認知症自立度Ⅱ以上の蓋然性(new RString(entity.getDbt5116_iIijoNoGaizensei().intValue()));
        RString dbt5207厚労省IF識別コード = entity.getDbt5207_koroshoIfShikibetsuCode().getColumnValue();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getDbt5202_serviceKubunCode().getColumnValue())) {
            item = set介護給付サービス(item, dbt5207厚労省IF識別コード, 厚労省IF識別コード, entity, itiziHanteiEntityList);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getDbt5202_serviceKubunCode().getColumnValue())) {
            item = set予防給付サービス(item, dbt5207厚労省IF識別コード, 厚労省IF識別コード, entity, itiziHanteiEntityList);
        }
        RString dbT5211厚労省IF識別コード = entity.getDbt5211_koroshoIfShikibetsuCode().getColumnValue();
        item = コード転換(item, entity);
        entity.getDbt5211_remban();
        for (ItiziHanteiEntity itiziHanteiEntity : itiziHanteiEntityList) {
            if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().getColumnValue())) {
                if (getコード(厚労省IF識別コード, new RString("麻痺等の有無（左上肢）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_麻痺_左_上肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_麻痺_左_上肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("麻痺等の有無（右上肢）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_麻痺_右_上肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_麻痺_右_上肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("麻痺等の有無（左下肢）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_麻痺_左_下肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_麻痺_左_下肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("麻痺等の有無（右下肢）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_麻痺_右_下肢(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_麻痺_右_下肢_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("麻痺等の有無（その他）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_麻痺_その他(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_麻痺_その他_ある(get麻痺特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("関節の動く範囲の制限（肩関節）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_拘縮_肩関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_拘縮_肩関節_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("関節の動く範囲の制限（股関節）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_拘縮_股関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_拘縮_股関節_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("関節の動く範囲の制限（膝関節）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_拘縮_膝関節(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_拘縮_膝関節_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("関節の動く範囲の制限（その他）")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_拘縮_その他(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_拘縮_その他_ある(get拘縮の有無特記事項_ある(厚労省IF識別コード, 特記事項情報));
                }
                if (getコード(厚労省IF識別コード, new RString("寝返り")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_寝返り(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_寝返り_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("寝返り")));
                }
                if (getコード(厚労省IF識別コード, new RString("起き上がり")) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_起き上がり(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_起き上がり_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("起き上がり")));
                }
                if (get座位保持コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                    item.set調査結果_座位保持(ChosaAnser03.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                    item.set調査結果_座位保持_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("座位保持")));
                }
            }
            item = set調査結果1(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報);
            item = set調査結果2(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報);
            item = set調査結果3(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報);
            item = set調査結果4(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity, 特記事項情報);
            item = itemSetteiTwo.set認定調査と主治医意見書の結果比較(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        }

        return item;
    }

    private IchijihanteikekkahyoItem set調査結果4(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().getColumnValue())) {
            if (get集団への不適応コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_集団への不適応(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_集団への不適応_ある(get集団への不適応特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get買い物コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_買い物(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_買い物_ある(get買い物特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get簡単な調理コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_簡単な調理(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_簡単な調理_ある(get簡単な調理特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（点滴の管理）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_点滴の管理(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_点滴の管理_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("点滴の管理")));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（中心静脈栄養）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_中心静脈栄養(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_中心静脈栄養_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報,
                        new RString("中心静脈栄養")));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（透析）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_透析(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_透析_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("透析")));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（ストーマの処置）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_ストーマの処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_ストーマの処置_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("ストーマの処置")));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（酸素療法）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_酸素療法(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_酸素療法_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("酸素療法")));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（レスピレーター）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_レスピレーター(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_レスピレーター_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報,
                        new RString("レスピレーター")));
            }
            if (get気管切開の処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_気管切開の処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_気管切開の処置_ある(get気管切開の処置特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（疼痛の看護）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_気管切開の処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_気管切開の処置_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報,
                        new RString("疼痛の看護")));
            }
            if (getコード(厚労省IF識別コード, new RString("処置内容（経管栄養）")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_経管栄養(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_経管栄養_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("経管栄養")));
            }
            if (getモニター測定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_モニター測定(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_モニター測定_ある(getモニター測定特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (getじょくそうの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_じょくそうの処置(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_じょくそうの処置_ある(getじょくそうの処置特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (getカテーテルコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_カテーテル(ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_カテーテル_ある(getカテーテル特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果3(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().getColumnValue())) {
            if (get同じ話をするコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_同じ話をする(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_同じ話をする_ある(get同じ話をする特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get大声を出すコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_大声を出す(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_大声を出す_ある(get大声を出す特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get介護に抵抗コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_介護に抵抗(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_介護に抵抗_ある(get介護に抵抗特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get落ち着きなしコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_落ち着きなし(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_落ち着きなし_ある(get落ち着きなし特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get一人で出たがるコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_一人で出たがる(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_一人で出たがる_ある(get一人で出たがる特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get収集癖コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_収集癖(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_収集癖_ある(get収集癖特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get物や衣類を壊すコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_物や衣類を壊す(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_物や衣類を壊す_ある(get物や衣類を壊す特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (getひどい物忘れコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_ひどい物忘れ(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_ひどい物忘れ_ある(getひどい物忘れ特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get独り言_独り笑いコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_独り言_独り笑い(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_独り言_独り笑い_ある(get独り言_独り笑い特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get自分勝手に行動するコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_自分勝手に行動する(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_自分勝手に行動する_ある(get自分勝手に行動する特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get話がまとまらないコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_話がまとまらない(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_話がまとまらない_ある(get話がまとまらない特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get薬の内服コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_薬の内服(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_薬の内服_ある(get薬の内服特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get金銭の管理コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_金銭の管理(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_金銭の管理_ある(get金銭の管理特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get日常の意思決定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_日常の意思決定(ChosaAnser17.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_日常の意思決定_ある(get日常の意思決定特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果2(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().getColumnValue())) {
            if (getコード(厚労省IF識別コード, new RString("整髪")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_整髪(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_整髪_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("整髪")));
            }
            if (getコード(厚労省IF識別コード, new RString("上衣の着脱")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_上衣の着脱(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_上衣の着脱_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("上衣の着脱")));
            }
            if (getズボン等の着脱コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_ズボン等の着脱(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_ズボン等の着脱_ある(getズボン等の着脱特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get外出頻度コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_外出頻度(ChosaAnser13.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_外出頻度_ある(get外出頻度特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get意思の伝達コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_意思の伝達(ChosaAnser14.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_意思の伝達_ある(get意思の伝達特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get毎日の日課を理解コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_毎日の日課を理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_毎日の日課を理解_ある(get毎日の日課を理解特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get生年月日をいうコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_生年月日をいう(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_生年月日をいう_ある(get生年月日をいう特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get短期記憶コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_短期記憶(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_短期記憶_ある(get短期記憶特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get自分の名前をいうコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_自分の名前をいう(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_自分の名前をいう_ある(get自分の名前をいう特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get今の季節を理解コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_今の季節を理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_今の季節を理解_ある(get今の季節を理解特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get場所の理解コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_場所の理解(ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_場所の理解_ある(get場所の理解特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get徘徊コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_徘徊(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_徘徊_ある(get徘徊特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get外出して戻れないコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_外出して戻れない(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_外出して戻れない_ある(get外出して戻れない特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get被害的コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_被害的(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_被害的_ある(get被害的特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get作話コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_作話(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_作話_ある(get作話特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get感情が不安定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_感情が不安定(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_感情が不安定_ある(get感情が不安定特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (get昼夜逆転コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_昼夜逆転(ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_昼夜逆転_ある(get昼夜逆転特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set調査結果1(IchijihanteikekkahyoItem item, RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード,
            ItiziHanteiEntity itiziHanteiEntity, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().getColumnValue())) {
            if (getコード(厚労省IF識別コード, new RString("両足での立位")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_座位保持(ChosaAnser04.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_座位保持_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("両足での立位保持")));
            }
            if (getコード(厚労省IF識別コード, new RString("歩行")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_歩行(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_歩行_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("歩行")));
            }
            if (getコード(厚労省IF識別コード, new RString("立ち上がり")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_立ち上がり(ChosaAnser02.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_立ち上がり_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("立ち上がり")));
            }
            if (getコード(厚労省IF識別コード, new RString("片足での立位")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_片足での立位(ChosaAnser04.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_片足での立位_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("片足での立位")));
            }
            if (getコード(厚労省IF識別コード, new RString("洗身")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_洗身(ChosaAnser06.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_洗身_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("洗身")));
            }
            if (getコード(厚労省IF識別コード, new RString("つめ切り")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_つめ切り(ChosaAnser07.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_つめ切り_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("つめ切り")));
            }
            if (getコード(厚労省IF識別コード, new RString("視力")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_視力(ChosaAnser08.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_視力_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("視力")));
            }
            if (getコード(厚労省IF識別コード, new RString("聴力")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_聴力(ChosaAnser09.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_聴力_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("聴力")));
            }
            if (getコード(厚労省IF識別コード, new RString("移動")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_移動(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_移動_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("移動")));
            }
            if (getえん下コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_えん下(ChosaAnser11.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_えん下_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("えん下")));
            }
            if (getコード(厚労省IF識別コード, new RString("食事摂取")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_食事摂取(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_食事摂取_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("食事摂取")));
            }
            if (get排尿コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_排尿(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_排尿_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("排尿")));
            }
            if (get排便コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_排便(ChosaAnser10.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_排便_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("排便")));
            }
            if (getコード(厚労省IF識別コード, new RString("口腔清潔")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_口腔清潔(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_口腔清潔_ある(get口腔清潔特記事項_ある(厚労省IF識別コード, 特記事項情報));
            }
            if (getコード(厚労省IF識別コード, new RString("洗顔")) == itiziHanteiEntity.getDbt5211_remban()) {
                item.set調査結果_洗顔(ChosaAnser12.toValue(itiziHanteiEntity.getDbt5211_researchItem()).get名称());
                item.set調査結果_洗顔_ある(get特記事項_ある(厚労省IF識別コード, 特記事項情報, new RString("洗顔")));
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set予防給付サービス(IchijihanteikekkahyoItem item, RString dbt5207厚労省IF識別コード,
            RString 厚労省IF識別コード, ItiziHanteiEntity entity, List<ItiziHanteiEntity> itiziHanteiEntityList) {
        for (ItiziHanteiEntity itiziHanteiEntity : itiziHanteiEntityList) {
            if (dbt5207厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5101_koroshoIfShikibetsuCode().getColumnValue())
                    && entity.getDbt5202_serviceKubunCode().equals(itiziHanteiEntity.getDbt5202_serviceKubunCode())) {
                if (連番_1 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問介護_ホームヘルプサービス(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_2 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問入浴介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_3 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問看護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_4 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set訪問リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_5 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set居宅療養管理指導(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_6 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set通所介護_デイサービス(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_7 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set通所リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (A_99.equals(厚労省IF識別コード) || A_02.equals(厚労省IF識別コード)) {
                    item = set予防給付サービス_A_99_A_02(item, itiziHanteiEntity);
                }
                item = set予防給付サービス_A_06_A_09_B_09(item, itiziHanteiEntity, 厚労省IF識別コード);
                if (B_09.equals(厚労省IF識別コード) && 連番_19 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set定期巡回_随時対応型訪問介護看護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (B_09.equals(厚労省IF識別コード) && 連番_20 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set看護小規模多機能型居宅介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set予防給付サービス_A_06_A_09_B_09(IchijihanteikekkahyoItem item,
            ItiziHanteiEntity itiziHanteiEntity, RString 厚労省IF識別コード) {
        if (A_06.equals(厚労省IF識別コード) || A_09.equals(厚労省IF識別コード)
                || B_09.equals(厚労省IF識別コード)) {
            if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set特定福祉用具販売(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_13 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set夜間対応型訪問介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_14 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set認知症対応型通所介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_15 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set小規模多機能型居宅介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_16 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_17 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set地域密着型特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
            if (連番_18 == itiziHanteiEntity.getDbt5207_remban()) {
                item.set地域密着型介護老人福祉施設入所者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set予防給付サービス_A_99_A_02(IchijihanteikekkahyoItem item, ItiziHanteiEntity itiziHanteiEntity) {
        if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set福祉用具貸与(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_11 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        return item;
    }

    private IchijihanteikekkahyoItem set介護給付サービス(IchijihanteikekkahyoItem item, RString dbt5207厚労省IF識別コード,
            RString 厚労省IF識別コード, ItiziHanteiEntity entity, List<ItiziHanteiEntity> itiziHanteiEntityList) {
        for (ItiziHanteiEntity itiziHanteiEntity : itiziHanteiEntityList) {
            if (dbt5207厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5101_koroshoIfShikibetsuCode().getColumnValue())
                    && entity.getDbt5202_serviceKubunCode().equals(itiziHanteiEntity.getDbt5202_serviceKubunCode())) {
                if (連番_1 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問介護_ﾎｰﾑﾍﾙﾌﾟ_訪問型ｻｰﾋﾞｽ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_2 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問入浴介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_3 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問看護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_4 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防訪問リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_5 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防居宅療養管理指導(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_6 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防通所介護_ﾃﾞｲｻｰﾋﾞｽ_通所型ｻｰﾋﾞｽ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (連番_7 == itiziHanteiEntity.getDbt5207_remban()) {
                    item.set介護予防通所リハビリテーション(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
                }
                if (A_99.equals(厚労省IF識別コード) || A_02.equals(厚労省IF識別コード)) {
                    item = set介護給付サービス_A_99_A_02(item, itiziHanteiEntity);
                }
                if (A_06.equals(厚労省IF識別コード) || A_09.equals(厚労省IF識別コード)
                        || B_09.equals(厚労省IF識別コード)) {
                    set介護給付サービス_A_06_A_09_B_09(item, itiziHanteiEntity);
                }
            }
        }
        return item;
    }

    private IchijihanteikekkahyoItem set介護給付サービス_A_06_A_09_B_09(IchijihanteikekkahyoItem item, ItiziHanteiEntity itiziHanteiEntity) {
        if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set特定介護予防福祉用具販売(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_14 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型通所介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_15 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防小規模多機能型居宅介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_16 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        return item;
    }

    private IchijihanteikekkahyoItem set介護給付サービス_A_99_A_02(IchijihanteikekkahyoItem item, ItiziHanteiEntity itiziHanteiEntity) {
        if (連番_8 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防福祉用具貸与(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_9 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所生活介護_ショートステイ(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_10 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防短期入所療養介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_12 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防特定施設入居者生活介護(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        if (連番_11 == itiziHanteiEntity.getDbt5207_remban()) {
            item.set介護予防認知症対応型共同生活介護_グループホーム(new RString(itiziHanteiEntity.getDbt5207_serviceJokyo()));
        }
        return item;
    }

    private RString getカテーテル特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.カテーテル.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.カテーテル.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.カテーテル.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.カテーテル.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int getカテーテルコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.カテーテル.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.カテーテル.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.カテーテル.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.カテーテル.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.カテーテル.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString getじょくそうの処置特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.じょくそうの処置.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int getじょくそうの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.じょくそうの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.じょくそうの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.じょくそうの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.じょくそうの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.じょくそうの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString getモニター測定特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.モニター測定.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.モニター測定.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.モニター測定.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.モニター測定.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int getモニター測定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.モニター測定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.モニター測定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.モニター測定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.モニター測定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.モニター測定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get気管切開の処置特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.気管切開の処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.気管切開の処置.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.気管切開.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.気管切開.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get気管切開の処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.気管切開の処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.気管切開の処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.気管切開の処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.気管切開の処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.気管切開の処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get簡単な調理特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.簡単な調理.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.簡単な調理.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get簡単な調理コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.簡単な調理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.簡単な調理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get買い物特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.買い物.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.買い物.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get買い物コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.買い物.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.買い物.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get集団への不適応特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.集団への不適応.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.集団への不適応.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get集団への不適応コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.集団への不適応.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.集団への不適応.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get日常の意思決定特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.意思決定.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.意思決定.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.日常の意思決定.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.日常の意思決定.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get日常の意思決定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.日常の意思決定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.日常の意思決定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.日常の意思決定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.日常の意思決定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get金銭の管理特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.金銭の管理.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.金銭の管理.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.金銭の管理.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.金銭の管理.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get金銭の管理コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.金銭の管理.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.金銭の管理.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.金銭の管理.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.金銭の管理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.金銭の管理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get薬の内服特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.薬の内服.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.薬の内服.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.薬の内服.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.薬の内服.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get薬の内服コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.薬の内服.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.薬の内服.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.薬の内服.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.薬の内服.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.薬の内服.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get話がまとまらない特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.話がまとまらない.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.話がまとまらない.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get話がまとまらないコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.話がまとまらない.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.話がまとまらない.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get自分勝手に行動する特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.自分勝手に行動する.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.自分勝手に行動する.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get自分勝手に行動するコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.自分勝手に行動する.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get独り言_独り笑い特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.独り言独り笑い.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.独り言独り笑い.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get独り言_独り笑いコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.独り言_独り笑い.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString getひどい物忘れ特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.ひどい物忘れ.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int getひどい物忘れコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.ひどい物忘れ.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.ひどい物忘れ.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.ひどい物忘れ.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.ひどい物忘れ.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get物や衣類を壊す特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.物や衣類を壊す.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get物や衣類を壊すコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.物や衣類を壊す.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.物や衣類を壊す.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.物や衣類を壊す.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.物や衣類を壊す.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get収集癖特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.収集癖.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.収集癖.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.収集癖.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.収集癖.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get収集癖コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.収集癖.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.収集癖.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.収集癖.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.収集癖.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.収集癖.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get一人で出たがる特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.一人で出たがる.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get一人で出たがるコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.一人で出たがる.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.一人で出たがる.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.一人で出たがる.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.一人で出たがる.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.一人で出たがる.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get落ち着きなし特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.落ち着きなし.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get落ち着きなしコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.落ち着きなし.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.落ち着きなし.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.落ち着きなし.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.落ち着きなし.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.落ち着きなし.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get介護に抵抗特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.介護に抵抗.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get介護に抵抗コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.介護に抵抗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.介護に抵抗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.介護に抵抗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.介護に抵抗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.介護に抵抗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get大声を出す特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.大声をだす.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.大声をだす.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.大声を出す.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.大声を出す.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get大声を出すコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.大声をだす.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.大声をだす.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.大声をだす.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.大声を出す.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.大声を出す.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get同じ話をする特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.同じ話をする.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.同じ話をする.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.同じ話をする.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.同じ話をする.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get同じ話をするコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.同じ話をする.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.同じ話をする.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.同じ話をする.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.同じ話をする.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.同じ話をする.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get昼夜逆転特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.昼夜逆転.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get昼夜逆転コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.昼夜逆転.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.昼夜逆転.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.昼夜逆転.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.昼夜逆転.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.昼夜逆転.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get感情が不安定特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.感情が不安定.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.感情が不安定.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.感情が不安定.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.感情が不安定.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get感情が不安定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.感情が不安定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.感情が不安定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.感情が不安定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.感情が不安定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.感情が不安定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get作話特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.作話.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.作話.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.作話.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.作話.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get作話コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.作話.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.作話.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.作話.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.作話.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.作話.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get被害的特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.被害的.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.被害的.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.被害的.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.被害的.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get被害的コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.被害的.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.被害的.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.被害的.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.被害的.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.被害的.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get外出して戻れない特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.外出して戻れない.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.外出して戻れない.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.外出頻度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.外出頻度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get外出して戻れないコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.外出して戻れない.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.外出して戻れない.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.外出して戻れない.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.外出して戻れない.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.外出して戻れない.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get徘徊特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.常時の徘徊.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.常時の徘徊.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.徘徊.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.徘徊.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get徘徊コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.常時の徘徊.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.常時の徘徊.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.常時の徘徊.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.常時の徘徊.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.常時の徘徊.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get場所の理解特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.自分がいる場所の理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.自分がいる場所の理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.場所の理解.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.場所の理解.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get場所の理解コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.場所の理解.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.場所の理解.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.場所の理解.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.場所の理解.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.場所の理解.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get今の季節を理解特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.今の季節を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.今の季節を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.今の季節を理解する.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.今の季節を理解する.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get今の季節を理解コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.今の季節を理解.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.今の季節を理解.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.今の季節を理解.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.今の季節を理解.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.今の季節を理解.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get自分の名前をいう特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.自分の名前をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.自分の名前をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.自分の名前を言う.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.自分の名前を言う.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get自分の名前をいうコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.自分の名前をいう.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.自分の名前をいう.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.自分の名前をいう.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.自分の名前をいう.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.自分の名前をいう.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get短期記憶特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.短期記憶.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.短期記憶.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.短期記憶.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.短期記憶.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get短期記憶コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.短期記憶.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.短期記憶.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.短期記憶.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.短期記憶.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.短期記憶.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get生年月日をいう特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.生年月日や年齢をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.生年月日や年齢をいう.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.生年月日や年齢を言う.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.生年月日や年齢を言う.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get生年月日をいうコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.生年月日をいう.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.生年月日をいう.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.生年月日をいう.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.生年月日をいう.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.生年月日をいう.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get毎日の日課を理解特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.毎日の日課を理解.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get毎日の日課を理解コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.毎日の日課を理解.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.毎日の日課を理解.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.毎日の日課を理解.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.毎日の日課を理解.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get意思の伝達特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.意思の伝達.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.意思の伝達.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.意思の伝達.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.意思の伝達.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get意思の伝達コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.意思の伝達.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.意思の伝達.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.意思の伝達.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.意思の伝達.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.意思の伝達.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get外出頻度特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.外出頻度.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.外出頻度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.外出頻度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get外出頻度コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.外出頻度.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.外出頻度.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.外出頻度.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString getズボン等の着脱特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.ズボン等の着脱.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int getズボン等の着脱コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.ズボン等の着脱.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.ズボン等の着脱.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.ズボン等の着脱.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.ズボン等の着脱.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get口腔清潔特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.口腔清潔.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.口腔清潔.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.口腔清潔.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.口腔清潔.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private int get排便コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.排便後の後始末.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.排便.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.排便.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.排便.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.排便.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get排尿コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.排尿後の後始末.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.排尿.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.排尿.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.排尿.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.排尿.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getえん下コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.えん下.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.えん下.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.えん下.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.えん下.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.えん下.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get座位保持コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.両足がついた座位保持.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.座位保持.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.座位保持.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.座位保持.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.座位保持.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getコード(RString 厚労省IF識別コード, RString 名称) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.valueOf(名称.toString()).getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.valueOf(名称.toString()).getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.valueOf(名称.toString()).getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.valueOf(名称.toString()).getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.valueOf(名称.toString()).getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString get特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報, RString 名称) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.valueOf(名称.toString()).get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.valueOf(名称.toString()).get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.valueOf(名称.toString()).get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.valueOf(名称.toString()).get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get拘縮の有無特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.間接の動く範囲の制限の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.間接の動く範囲の制限の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.拘縮の有無.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.拘縮の有無.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get麻痺特記事項_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.麻痺等の有無.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get認知症高齢者自立度_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.認知症高齢者自立度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private RString get障害高齢者自立度_ある(RString 厚労省IF識別コード, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku02A.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku06A.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09A.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return get特記事項(is特記事項(NinteichosaKomoku09B.障害高齢者自立度.get調査特記事項番序(), 特記事項情報));
        }
        return RString.EMPTY;
    }

    private boolean is特記事項(RString 調査特記事項番号, List<NinteichosahyoTokkijikoEntity> 特記事項情報) {
        List<RString> 特記事項番号 = new ArrayList<>();
        RString 特記事項符号有無 = DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        for (NinteichosahyoTokkijikoEntity entity : 特記事項情報) {
            特記事項番号.add(new RString(entity.getRokkijikoRemban()));
        }
        return 印字する.equals(特記事項符号有無) && 特記事項番号.contains(調査特記事項番号);
    }

    private RString get特記事項(boolean is特記事項) {
        if (is特記事項) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    private RString 前々回認定有効期間(FlexibleDate 前回認定有効期間_開始, FlexibleDate 前回認定有効期間_終了) {
        RStringBuilder builder = new RStringBuilder();
        if (前回認定有効期間_開始 != null && !前回認定有効期間_開始.isEmpty()
                && 前回認定有効期間_終了 != null && !前回認定有効期間_終了.isEmpty()) {
            builder.append(前回認定有効期間_終了.getMonthValue() - 前回認定有効期間_開始.getMonthValue() + 1)
                    .append(月間);
            return builder.toRString();
        }
        return RString.EMPTY;
    }

    private RString パターン17(FlexibleDate 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString パターン16(FlexibleDate 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private IchijihanteikekkahyoItem コード転換(IchijihanteikekkahyoItem item, ItiziHanteiEntity entity) {
        item.set申請区分(entity.getDbt5101_ninteiKubunCode() == null || entity.getDbt5101_ninteiKubunCode().isEmpty() ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(entity.getDbt5101_ninteiKubunCode().getColumnValue()).get名称());
        item.set性別(entity.getDbt5101_seibetsu() == null || entity.getDbt5101_seibetsu().isEmpty()
                ? RString.EMPTY : Seibetsu.toValue(entity.getDbt5101_seibetsu().getColumnValue()).get名称());
        item.set前回要介護度(entity.getDbt5101_zenYokaigoKubunCode() == null || entity.getDbt5101_zenYokaigoKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getDbt5101_zenYokaigoKubunCode().getColumnValue()).get名称());
        item.set前回状態像(entity.getDbt5101_zenYokaigoKubunCode() == null || entity.getDbt5101_zenYokaigoKubunCode().isEmpty() ? RString.EMPTY
                : YokaigoJotaiKubun09.toValue(entity.getDbt5101_zenYokaigoKubunCode().getColumnValue()).get名称());
        item.set一次判定結果(entity.getDbt5116_ichijiHanteiKekkaCode() == null || entity.getDbt5116_ichijiHanteiKekkaCode().isEmpty() ? RString.EMPTY
                : IchijiHanteiKekkaCode09.toValue(entity.getDbt5116_ichijiHanteiKekkaCode().getColumnValue()).get名称());
        item.set障害高齢者自立度(entity.getDbT5203_shogaiCode() == null || entity.getDbT5203_shogaiCode().isEmpty() ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_shogaiCode().getColumnValue()).get名称());
        item.set認知症高齢者自立度(entity.getDbT5203_ninchishoCode() == null || entity.getDbT5203_ninchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_ninchishoCode().getColumnValue()).get名称());
        item = setコード転換(item, entity);
        return item;
    }

    private IchijihanteikekkahyoItem setコード転換(IchijihanteikekkahyoItem item, ItiziHanteiEntity entity) {
        item.set認定調査結果認知症高齢者自立度(
                entity.getDbT5203_ninchishoCode() == null || entity.getDbT5203_ninchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_ninchishoCode().getColumnValue()).get名称());
        item.set意見書認知症高齢者自立度(entity.getDbT5203_ninchishoCode() == null || entity.getDbT5203_ninchishoCode().isEmpty() ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getDbT5203_ninchishoCode().getColumnValue()).get名称());
        item.set状態の安定性(entity.getDbt5116_jotaiAnteiseiCode() == null || entity.getDbt5116_jotaiAnteiseiCode().isEmpty() ? RString.EMPTY
                : JotaiAnteiseiCode.toValue(entity.getDbt5116_jotaiAnteiseiCode().getColumnValue()).get名称());
        item.set給付区分(entity.getDbt5116_suiteiKyufuKubunCode() == null || entity.getDbt5116_suiteiKyufuKubunCode().isEmpty() ? RString.EMPTY
                : SuiteiKyufuKubunCode.toValue(entity.getDbt5116_suiteiKyufuKubunCode().getColumnValue()).get名称());
        item.set現在のサービス利用状況(entity.getDbt5202_serviceKubunCode() == null || entity.getDbt5202_serviceKubunCode().isEmpty() ? RString.EMPTY
                : ServiceKubunCode.toValue(entity.getDbt5202_serviceKubunCode().getColumnValue()).get名称());
        return item;
    }
}
