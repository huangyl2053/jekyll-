/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8235 船山洋介
 */
public final class DbT5101NinteiShinseiJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("00000000000000999");
    public static final Code DEFAULT_厚労省IF識別コード = new Code("001");
    public static final RString DEFAULT_証記載保険者番号 = new RString("000001");
    public static final FlexibleYear DEFAULT_申請年度 = new FlexibleYear("2014");
    public static final RString DEFAULT_被保険者番号 = new RString("000001");
    public static final FlexibleDate DEFAULT_認定申請年月日 = new FlexibleDate("20141212");
    public static final EdabanCode DEFAULT_認定申請枝番コード = new EdabanCode("001");
    public static final Code DEFAULT_認定申請区分_法令_コード = new Code("0001");
    public static final Code DEFAULT_認定申請区分_申請時_コード = new Code("0001");
    public static final Code DEFAULT_取下区分コード = new Code("0001");
    public static final RString DEFAULT_被保険者区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("19700101");
    public static final int DEFAULT_年齢 = 45;
    public static final Code DEFAULT_性別 = new Code(new RString("1"));
    public static final AtenaKanaMeisho DEFAULT_被保険者氏名カナ = new AtenaKanaMeisho("ヒホケンシャ");
    public static final AtenaMeisho DEFAULT_被保険者氏名 = new AtenaMeisho("被保険者");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1234567890");
    public static final RString DEFAULT_支所コード = new RString("123456789");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("0001");
    public static final ChikuCode DEFAULT_地区コード = new ChikuCode("00000001");
    public static final boolean DEFAULT_みなし二号等対象フラグ = false;
    public static final Code DEFAULT_広域内転居区分 = new Code("1");
    public static final Code DEFAULT_認定申請有効区分 = new Code("1");
    public static final RString DEFAULT_要介護申請_要支援申請の区分 = new RString("1");
    public static final RString DEFAULT_認定申請理由 = new RString("認定申請理由");
    public static final RString DEFAULT_申請サービス削除の理由 = new RString("申請サービス削除理由");
    public static final Code DEFAULT_前回要介護状態区分コード = new Code("1");
    public static final FlexibleDate DEFAULT_前回認定年月日 = new FlexibleDate("20150808");
    public static final FlexibleDate DEFAULT_前回認定有効期間_開始 = new FlexibleDate("20150809");
    public static final FlexibleDate DEFAULT_前回認定有効期間_終了 = new FlexibleDate("20160809");
    public static final RString DEFAULT_二号医療保険者名 = new RString("二号保険者名");
    public static final RString DEFAULT_二号医療保険記号番号 = new RString("01223");
    public static final Code DEFAULT_二号特定疾病コード = new Code("0001");
    public static final RString DEFAULT_自動割当除外者区分 = new RString("1");
    public static final boolean DEFAULT_情報提供への同意有無 = true;
    public static final FlexibleDate DEFAULT_情報提供資料出力年月日 = new FlexibleDate("20150807");
    public static final Code DEFAULT_調査区分 = new Code("01");
    public static final ChosaItakusakiCode DEFAULT_認定調査委託先コード = new ChosaItakusakiCode("0000000001");
    public static final ChosainCode DEFAULT_認定調査員コード = new ChosainCode("00000001");
    public static final RString DEFAULT_調査員への連絡事項 = new RString("調査員への連絡事項");
    public static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード = new ShujiiIryokikanCode("0000000001");
    public static final ShujiiCode DEFAULT_主治医コード = new ShujiiCode("00000001");
    public static final boolean DEFAULT_指定医フラグ = false;
    public static final Code DEFAULT_意見書データ種別 = new Code("01");
    public static final RString DEFAULT_主治医への連絡事項 = new RString("主治医への連絡事項");
    public static final Code DEFAULT_みなし要介護区分コード = new Code("1");
    public static final boolean DEFAULT_認定延期通知発行しないことに対する同意有無 = false;
    public static final boolean DEFAULT_施設入所の有無 = false;
    public static final JigyoshaNo DEFAULT_入所施設コード = new JigyoshaNo("0000000001");
    public static final boolean DEFAULT_家庭訪問の有無 = false;
    public static final YubinNo DEFAULT_訪問調査先郵便番号 = new YubinNo("7654321");
    public static final AtenaJusho DEFAULT_訪問調査先住所 = new AtenaJusho("訪問先受住所");
    public static final AtenaMeisho DEFAULT_訪問調査先名称 = new AtenaMeisho("訪問先名称");
    public static final TelNo DEFAULT_訪問調査先電話番号 = new TelNo("0000111111");
    public static final RString DEFAULT_市町村連絡事項 = new RString("市町村連絡事項");
    public static final Code DEFAULT_処理状態区分 = new Code("1");
    public static final FlexibleDate DEFAULT_取下年月日 = new FlexibleDate("20150104");
    public static final RString DEFAULT_取下理由 = new RString("取下げ理由");
    public static final FlexibleDate DEFAULT_却下年月日 = new FlexibleDate("20150106");
    public static final RString DEFAULT_却下理由 = new RString("却下理由");
    public static final FlexibleDate DEFAULT_延期決定年月日 = new FlexibleDate("20150108");
    public static final RString DEFAULT_延期理由 = new RString("延期理由");
    public static final FlexibleDate DEFAULT_延期通知発行年月日 = new FlexibleDate("20150110");
    public static final int DEFAULT_延期通知発行回数 = 1;
    public static final FlexibleDate DEFAULT_延期見込期間開始年月日 = new FlexibleDate("20150210");
    public static final FlexibleDate DEFAULT_延期見込期間終了年月日 = new FlexibleDate("20150211");
    public static final boolean DEFAULT_審査継続区分 = false;
    public static final Code DEFAULT_要介護認定審査会優先振分区分コード = new Code("1");
    public static final FlexibleDate DEFAULT_更新通知発行年月日 = new FlexibleDate("20160810");
    public static final FlexibleDate DEFAULT_更新通知発行完了年月日 = new FlexibleDate("20160811");
    public static final FlexibleDate DEFAULT_認定申請情報登録年月日 = new FlexibleDate("20150810");
    public static final int DEFAULT_再調査依頼回数 = 0;
    public static final int DEFAULT_再作成依頼回数 = 1;
    public static final FlexibleDate DEFAULT_ＩＦ送付年月日 = new FlexibleDate("20150102");
    public static final boolean DEFAULT_論理削除区分 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5101NinteiShinseiJohoEntityGenerator() {
    }

    public static DbT5101NinteiShinseiJohoEntity createDbT5101NinteiShinseiJohoEntity() {
        DbT5101NinteiShinseiJohoEntity entity = new DbT5101NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShinseiNendo(DEFAULT_申請年度);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setNinteiShinseiYMD(DEFAULT_認定申請年月日);
        entity.setNinteiShinseiEdabanCode(DEFAULT_認定申請枝番コード);
        entity.setNinteiShinseiHoreiKubunCode(DEFAULT_認定申請区分_法令_コード);
        entity.setNinteiShinseiShinseijiKubunCode(DEFAULT_認定申請区分_申請時_コード);
        entity.setTorisageKubunCode(DEFAULT_取下区分コード);
        entity.setHihokenshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setSeinengappiYMD(DEFAULT_生年月日);
        entity.setAge(DEFAULT_年齢);
        entity.setSeibetsu(DEFAULT_性別);
        entity.setHihokenshaKana(DEFAULT_被保険者氏名カナ);
        entity.setHihokenshaName(DEFAULT_被保険者氏名);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setChikuCode(DEFAULT_地区コード);
        entity.setMinashiNigoEtcTaishoFlag(DEFAULT_みなし二号等対象フラグ);
        entity.setKoikinaiTenkyoKubun(DEFAULT_広域内転居区分);
        entity.setNinteiShinseiYukoKubunCode(DEFAULT_認定申請有効区分);
        entity.setShienShinseiKubun(DEFAULT_要介護申請_要支援申請の区分);
        entity.setNinteiShinseiRiyu(DEFAULT_認定申請理由);
        entity.setShinseiServiceDeleteRiyu(DEFAULT_申請サービス削除の理由);
        entity.setZenYokaigoKubunCode(DEFAULT_前回要介護状態区分コード);
        entity.setZenkaiNinteiYMD(DEFAULT_前回認定年月日);
        entity.setZenkaiYukoKikanStart(DEFAULT_前回認定有効期間_開始);
        entity.setZenkaiYukoKikanEnd(DEFAULT_前回認定有効期間_終了);
        entity.setNigoIryoHokenshaName(DEFAULT_二号医療保険者名);
        entity.setNigoIryoHokenKigoBango(DEFAULT_二号医療保険記号番号);
        entity.setNigoTokuteiShippeiCode(DEFAULT_二号特定疾病コード);
        entity.setJidoWariateJogaishaKubun(DEFAULT_自動割当除外者区分);
        entity.setJohoteikyoDoiFlag(DEFAULT_情報提供への同意有無);
        entity.setJohoteikyoSiryoOutputYMD(DEFAULT_情報提供資料出力年月日);
        entity.setChosaKubun(DEFAULT_調査区分);
        entity.setNinteiChosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainCode(DEFAULT_認定調査員コード);
        entity.setRenrakuJikoToChosain(DEFAULT_調査員への連絡事項);
        entity.setShujiiIryokikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setShiteiiFlag(DEFAULT_指定医フラグ);
        entity.setIkenshoDataShubetsu(DEFAULT_意見書データ種別);
        entity.setRenrakuJikoToShujii(DEFAULT_主治医への連絡事項);
        entity.setEnkitsuchiNashiDoiFlag(DEFAULT_認定延期通知発行しないことに対する同意有無);
        entity.setShisetsuNyushoFlag(DEFAULT_施設入所の有無);
        entity.setNyushoShisetsuCode(DEFAULT_入所施設コード);
        entity.setKateiHomonFlag(DEFAULT_家庭訪問の有無);
        entity.setHomonChosasakiYubinNo(DEFAULT_訪問調査先郵便番号);
        entity.setHomonChosasakiJusho(DEFAULT_訪問調査先住所);
        entity.setHomonChosasakiName(DEFAULT_訪問調査先名称);
        entity.setHomonChosasakiTelNo(DEFAULT_訪問調査先電話番号);
        entity.setShichosonRenrakuJiko(DEFAULT_市町村連絡事項);
        entity.setShoriJotaiKubun(DEFAULT_処理状態区分);
        entity.setTorisageYMD(DEFAULT_取下年月日);
        entity.setTorisageRiyu(DEFAULT_取下理由);
        entity.setKyakkaYMD(DEFAULT_却下年月日);
        entity.setKyakkaRiyu(DEFAULT_却下理由);
        entity.setEnkiKetteiYMD(DEFAULT_延期決定年月日);
        entity.setEnkiRiyu(DEFAULT_延期理由);
        entity.setEnkiTsuchiHakkoYMD(DEFAULT_延期通知発行年月日);
        entity.setEnkiTsuchiHakkoKaisu(DEFAULT_延期通知発行回数);
        entity.setEnkiMikomiKaishiYMD(DEFAULT_延期見込期間開始年月日);
        entity.setEnkiMikomiShuryoYMD(DEFAULT_延期見込期間終了年月日);
        entity.setShinsaKeizokuFlag(DEFAULT_審査継続区分);
        entity.setShinsakaiYusenWaritsukeKubunCode(DEFAULT_要介護認定審査会優先振分区分コード);
        entity.setKoshinTsuchiHakkoYMD(DEFAULT_更新通知発行年月日);
        entity.setKoshinTsuchiHakkoKanryoYMD(DEFAULT_更新通知発行完了年月日);
        entity.setNinteiShinseiJohoTorokuYMD(DEFAULT_認定申請情報登録年月日);
        entity.setSaiChosaIraiKaisu(DEFAULT_再調査依頼回数);
        entity.setSaiSakuseiIraiKaisu(DEFAULT_再作成依頼回数);
        entity.setIfSofuYMD(DEFAULT_ＩＦ送付年月日);
        entity.setLogicalDeletedFlag(DEFAULT_論理削除区分);

        return entity;
    }
}
