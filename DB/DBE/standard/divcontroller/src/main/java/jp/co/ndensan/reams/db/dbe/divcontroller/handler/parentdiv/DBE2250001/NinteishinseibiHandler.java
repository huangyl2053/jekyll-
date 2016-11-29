/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ取込（モバイル）のHandlerラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class NinteishinseibiHandler {

    private final NinteishinseibiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteishinseibiDiv
     */
    public NinteishinseibiHandler(NinteishinseibiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査データ取込の設定します。
     *
     */
    public void initializtion() {
        div.getDgNinteiChosaData().setDataSource(new ArrayList<dgNinteiChosaData_Row>());
    }

    /**
     * 取込むの編集。
     *
     * @param row 認定調査一覧
     * @param entity ＣＳＶデータ
     */
    public void 取込むの編集(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        row.setJyoutai(new RString("変更"));
        row.setShichosonMeisho(entity.getHokenshaName());
        row.setNinteiShinseiYMD(entity.getNinteiShinseiYMD());
        row.setHihokenshaNo(entity.getHihokenshaNo());
        row.setHihokenshaName(entity.getHihokenshaName());
        row.setNinteiShinseiShinseijiKubunCode(entity.getNinteiShinseiShinseijiKubunName());
        row.setNinteichosaIraiKanryoYMD(entity.getNinteichosaIraiKanryoYMD());
        row.setNinteiChosaItakusakiCode(entity.getNinteiChosaItakusakiCode());
        row.setNinteiChosainCode(entity.getNinteiChosainCode());
        row.setNinteichosaJisshiYMD(entity.getNinteichosaJisshiYMD());
        row.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        row.setNinteichosaIraiRirekiNo(entity.getNinteichosaIraiRirekiNo());
        row.setRemban(entity.getResearchItemRemban());
        row.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        row.setShisetsuRiyoFlag(entity.getShisetsuRiyoFlag());
        row.setServiceJokyoKinyu(entity.getServiceJokyoKinyu());
        row.setServiceJokyo(entity.getServiceJokyo());
        row.setResearchItem(entity.getResearchItem());
        row.setNinchishoNichijoSeikatsuJiritsudoCode(entity.getNinchishoNichijoSeikatsuJiritsudoName());
        row.setShogaiNichijoSeikatsuJiritsudoCode(entity.getShogaiNichijoSeikatsuJiritsudoName());
        row.setNinteichosaTokkijikoNo(entity.getNinteichosaTokkijikoNo());
        row.setNinteichosaTokkijikoRemban(entity.getNinteichosaTokkijikoRemban());
        row.setGaikyoTokkiTextImageKubun(entity.getGaikyoTokkiTextImageKubunName());
        row.setGenponMaskKubun(entity.getGenponMaskKubunName());
        row.setTokkiJiko(entity.getTokkiJiko());
        row.setJutakuKaishu(entity.getJutakuKaishu());
        row.setTokubetsuKyufuService(entity.getTokubetsuKyufuService());
        row.setZaitakuService(entity.getZaitakuService());
        row.setShuso(entity.getShuso());
        row.setKazokuJokyo(entity.getKazokuJokyo());
        row.setKyojuKankyo(entity.getKyojuKankyo());
        row.setKikaiKiki(entity.getKikaiKiki());
        row.setNinteichousaIraiKubunCode(entity.getNinteichousaIraiKubunName());
        row.setNinteichosaIraiKaisu(entity.getNinteichosaIraiKaisu());
        row.setNinteichosaJuryoYMD(entity.getNinteichosaJuryoYMD());
        row.setNinteiChosaKubunCode(entity.getNinteiChosaKubunCode());
        row.setChosaJisshiBashoCode(entity.getChosaJisshiBashoCode());
        row.setChosaJisshiBashoMeisho(entity.getChosaJisshiBashoMeisho());
        row.setServiceKubunCode(entity.getServiceKubunName());
        row.setRiyoShisetsuShimei(entity.getRiyoShisetsuShimei());
        row.setRiyoShisetsuJusho(entity.getRiyoShisetsuJusho());
        row.setRiyoShisetsuTelNo(entity.getRiyoShisetsuTelNo());
        row.setRiyoShisetsuYubinNo(entity.getRiyoShisetsuYubinNo());
        row.setTokki(entity.getTokki());
        row.setTokkijikoUketsukeYMD(entity.getTokkijikoUketsukeYMD());
        row.setTokkijikoJuryoYMD(entity.getTokkijikoJuryoYMD());
        row.setServiceJokyoFlag(entity.getServiceJokyoFlag());
        row.setServiceJokyoRemban(entity.getServiceJokyoRemban());
        row.setServiceJokyoFlagRemban(entity.getServiceJokyoFlagRemban());
        row.setServiceJokyoKinyuRemban(entity.getServiceJokyoKinyuRemban());
        row.setShisetsuRiyoFlagRemban(entity.getShisetsuRiyoFlagRemban());
    }

    /**
     * 取込むの判定。
     *
     * @param row 認定調査一覧
     * @param entity ＣＳＶデータ
     * @return 取込むの判定
     */
    public boolean 取込むの判定(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return 取込むの判定_1(row, entity) || 取込むの判定_2(row, entity) || 取込むの判定_3(row, entity);
    }

    private boolean 取込むの判定_1(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return !row.getShichosonMeisho().equals(entity.getHokenshaName())
                || !row.getNinteiShinseiYMD().equals(entity.getNinteiShinseiYMD())
                || !row.getHihokenshaNo().equals(entity.getHihokenshaNo())
                || !row.getHihokenshaName().equals(entity.getHihokenshaName())
                || !row.getNinteiShinseiShinseijiKubunCode().equals(entity.getNinteiShinseiShinseijiKubunName())
                || !row.getNinteichosaIraiKanryoYMD().equals(entity.getNinteichosaIraiKanryoYMD())
                || !row.getNinteiChosaItakusakiCode().equals(entity.getNinteiChosaItakusakiCode())
                || !row.getNinteiChosainCode().equals(entity.getNinteiChosainCode())
                || !row.getNinteichosaJisshiYMD().equals(entity.getNinteichosaJisshiYMD())
                || !row.getShinseishoKanriNo().equals(entity.getShinseishoKanriNo())
                || !row.getNinteichosaIraiRirekiNo().equals(entity.getNinteichosaIraiRirekiNo())
                || !row.getRemban().equals(entity.getResearchItemRemban())
                || !row.getServiceJokyoRemban().equals(entity.getServiceJokyoRemban())
                || !row.getServiceJokyoFlagRemban().equals(entity.getServiceJokyoFlagRemban())
                || !row.getServiceJokyoKinyuRemban().equals(entity.getServiceJokyoKinyuRemban())
                || !row.getShisetsuRiyoFlagRemban().equals(entity.getShisetsuRiyoFlagRemban());
    }

    private boolean 取込むの判定_2(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return !row.getKoroshoIfShikibetsuCode().equals(entity.getKoroshoIfShikibetsuCode())
                || !row.getShisetsuRiyoFlag().equals(entity.getShisetsuRiyoFlag())
                || !row.getServiceJokyoKinyu().equals(entity.getServiceJokyoKinyu())
                || !row.getServiceJokyo().equals(entity.getServiceJokyo())
                || !row.getResearchItem().equals(entity.getResearchItem())
                || !row.getNinchishoNichijoSeikatsuJiritsudoCode().equals(entity.getNinchishoNichijoSeikatsuJiritsudoName())
                || !row.getShogaiNichijoSeikatsuJiritsudoCode().equals(entity.getShogaiNichijoSeikatsuJiritsudoName())
                || !row.getNinteichosaTokkijikoNo().equals(entity.getNinteichosaTokkijikoNo())
                || !row.getNinteichosaTokkijikoRemban().equals(entity.getNinteichosaTokkijikoRemban())
                || !row.getGaikyoTokkiTextImageKubun().equals(entity.getGaikyoTokkiTextImageKubunName())
                || !row.getGenponMaskKubun().equals(entity.getGenponMaskKubunName())
                || !row.getTokkiJiko().equals(entity.getTokkiJiko())
                || !row.getJutakuKaishu().equals(entity.getJutakuKaishu())
                || !row.getTokubetsuKyufuService().equals(entity.getTokubetsuKyufuService())
                || !row.getZaitakuService().equals(entity.getZaitakuService())
                || !row.getShuso().equals(entity.getShuso())
                || !row.getKazokuJokyo().equals(entity.getKazokuJokyo())
                || !row.getKyojuKankyo().equals(entity.getKyojuKankyo())
                || !row.getKikaiKiki().equals(entity.getKikaiKiki());

    }

    private boolean 取込むの判定_3(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return !row.getNinteichousaIraiKubunCode().equals(entity.getNinteichousaIraiKubunName())
                || !row.getNinteichosaIraiKaisu().equals(entity.getNinteichosaIraiKaisu())
                || !row.getNinteichosaJuryoYMD().equals(entity.getNinteichosaJuryoYMD())
                || !row.getNinteiChosaKubunCode().equals(entity.getNinteiChosaKubunCode())
                || !row.getChosaJisshiBashoCode().equals(entity.getChosaJisshiBashoCode())
                || !row.getChosaJisshiBashoMeisho().equals(entity.getChosaJisshiBashoMeisho())
                || !row.getServiceKubunCode().equals(entity.getServiceKubunName())
                || !row.getRiyoShisetsuShimei().equals(entity.getRiyoShisetsuShimei())
                || !row.getRiyoShisetsuJusho().equals(entity.getRiyoShisetsuJusho())
                || !row.getRiyoShisetsuTelNo().equals(entity.getRiyoShisetsuTelNo())
                || !row.getRiyoShisetsuYubinNo().equals(entity.getRiyoShisetsuYubinNo())
                || !row.getTokki().equals(entity.getTokki())
                || !row.getTokkijikoUketsukeYMD().equals(entity.getTokkijikoUketsukeYMD())
                || !row.getTokkijikoJuryoYMD().equals(entity.getTokkijikoJuryoYMD())
                || !row.getServiceJokyoFlag().equals(entity.getServiceJokyoFlag());
    }

    /**
     * 選択状態変更の判定。
     *
     * @return 取込むの判定
     */
    public boolean 選択状態変更の判定() {

        List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getSelectedItems();
        boolean flg = false;
        for (dgNinteiChosaData_Row row : rowList) {

            if (!RString.isNullOrEmpty(row.getJyoutai())) {

                flg = true;
            }
        }
        return flg;
    }

    /**
     * 認定調査票概況調査の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）
     * @return 認定調査票（概況調査）ビルダー
     */
    public NinteichosahyoGaikyoChosaBuilder 認定調査票概況調査の編集(dgNinteiChosaData_Row row, NinteichosahyoGaikyoChosa entity) {

        NinteichosahyoGaikyoChosaBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set概況調査テキストイメージ区分(TokkijikoTextImageKubun.valueOf(row.
                getGaikyoTokkiTextImageKubun().toString()).getコード());
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        if (!RString.isNullOrEmpty(row.getNinteichousaIraiKubunCode())) {

            builder.set認定調査依頼区分コード(new Code(NinteiChousaIraiKubunCode.
                    valueOf(row.getNinteichousaIraiKubunCode().toString()).getコード()));
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaIraiKaisu())) {

            builder.set認定調査回数(Integer.valueOf(row.getNinteichosaIraiKaisu().toString()));
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaJisshiYMD())) {
            builder.set認定調査実施年月日(toFlexibleDate(row.getNinteichosaJisshiYMD()));
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaJuryoYMD())) {
            builder.set認定調査受領年月日(toFlexibleDate(row.getNinteichosaJuryoYMD()));
        }
        if (!RString.isNullOrEmpty(row.getNinteiChosaKubunCode())) {
            builder.set認定調査区分コード(new Code(row.getNinteiChosaKubunCode()));
        }
        if (!RString.isNullOrEmpty(row.getNinteiChosaItakusakiCode())) {
            builder.set認定調査委託先コード(new JigyoshaNo(row.getNinteiChosaItakusakiCode()));
        }
        builder.set認定調査員コード(row.getNinteiChosainCode());
        if (!RString.isNullOrEmpty(row.getChosaJisshiBashoCode())) {
            builder.set認定調査実施場所コード(new Code(row.getChosaJisshiBashoCode()));
        }
        builder.set認定調査実施場所名称(row.getChosaJisshiBashoMeisho());
        if (!RString.isNullOrEmpty(row.getServiceKubunCode())) {
            builder.set認定調査_サービス区分コード(new Code(ServiceKubunCode.
                    valueOf(row.getServiceKubunCode().toString()).getコード()));
        }
        builder.set利用施設名(row.getRiyoShisetsuShimei());
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuJusho())) {
            builder.set利用施設住所(new AtenaJusho(row.getRiyoShisetsuJusho()));
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuTelNo())) {
            builder.set利用施設電話番号(new TelNo(row.getRiyoShisetsuTelNo()));
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuYubinNo())) {
            builder.set利用施設郵便番号(new YubinNo(row.getRiyoShisetsuYubinNo()));
        }
        builder.set特記(row.getTokki());
        if (!RString.isNullOrEmpty(row.getTokkijikoUketsukeYMD())) {
            builder.set認定調査特記事項受付年月日(toFlexibleDate(row.getTokkijikoUketsukeYMD()));
        }
        if (!RString.isNullOrEmpty(row.getTokkijikoJuryoYMD())) {
            builder.set認定調査特記事項受領年月日(toFlexibleDate(row.getTokkijikoJuryoYMD()));
        }
        return builder;
    }

    /**
     * 認定調査票概況特記の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況特記）
     * @return 認定調査票（概況特記）ビルダー
     */
    public GaikyoTokkiBuilder 認定調査票概況特記の編集(dgNinteiChosaData_Row row, GaikyoTokki entity) {

        GaikyoTokkiBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        if (!RString.isNullOrEmpty(row.getGaikyoTokkiTextImageKubun())) {

            builder.set概況特記テキストイメージ区分(TokkijikoTextImageKubun.valueOf(row.
                    getGaikyoTokkiTextImageKubun().toString()).getコード());
        }
        builder.set住宅改修(row.getJutakuKaishu());
        builder.set市町村特別給付サービス種類名(row.getTokubetsuKyufuService());
        builder.set介護保険給付以外の在宅サービス種類名(row.getZaitakuService());
        builder.set概況特記事項_主訴(row.getShuso());
        builder.set概況特記事項_家族状況(row.getKazokuJokyo());
        builder.set概況特記事項_居住環境(row.getKyojuKankyo());
        builder.set概況特記事項_機器_器械(row.getKikaiKiki());

        return builder;
    }

    /**
     * 認定調査票特記情報の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（特記情報）
     * @return 認定調査票（特記情報）ビルダー
     */
    public NinteichosahyoTokkijikoBuilder 認定調査票特記情報の編集(dgNinteiChosaData_Row row, NinteichosahyoTokkijiko entity) {

        NinteichosahyoTokkijikoBuilder builder = entity.createBuilderForEdit();

        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set認定調査特記事項番号(row.getNinteichosaTokkijikoNo());
        builder.set認定調査特記事項連番(Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()));
        if (!RString.isNullOrEmpty(row.getGaikyoTokkiTextImageKubun())) {

            builder.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.
                    valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());
        }
        builder.set原本マスク区分(new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()));
        builder.set特記事項(row.getTokkiJiko());
        return builder;
    }

    /**
     * 認定調査票基本調査の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（基本調査）
     * @return 認定調査票（基本調査）ビルダー
     */
    public NinteichosahyoKihonChosaBuilder 認定調査票基本調査の編集(dgNinteiChosaData_Row row, NinteichosahyoKihonChosa entity) {

        NinteichosahyoKihonChosaBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set認定調査_認知症高齢者の日常生活自立度コード(new Code(NinchishoNichijoSeikatsuJiritsudoCode.
                valueOf(row.getNinchishoNichijoSeikatsuJiritsudoCode().toString()).getコード()));
        builder.set認定調査_障害高齢者の日常生活自立度コード(new Code(ShogaiNichijoSeikatsuJiritsudoCode.
                valueOf(row.getShogaiNichijoSeikatsuJiritsudoCode().toString()).getコード()));
        return builder;
    }

    /**
     * 認定調査票基本調査調査項目の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（基本調査）調査項目
     * @return 認定調査票（基本調査）調査項目ビルダー
     */
    public NinteichosahyoChosaItemBuilder 認定調査票基本調査調査項目の編集(dgNinteiChosaData_Row row, NinteichosahyoChosaItem entity) {

        NinteichosahyoChosaItemBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set調査項目(row.getResearchItem());
        return builder;
    }

    /**
     * 認定調査票概況調査サービスの状況の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）サービスの状況
     * @return 認定調査票（概況調査）サービスの状況ビルダー
     */
    public NinteichosahyoServiceJokyoBuilder 認定調査票概況調査サービスの状況の編集(dgNinteiChosaData_Row row, NinteichosahyoServiceJokyo entity) {

        NinteichosahyoServiceJokyoBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getServiceJokyoRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.setサービスの状況(Integer.valueOf(row.getServiceJokyo().toString()));
        return builder;
    }

    /**
     * 認定調査票概況調査サービスの状況フラグの編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）サービスの状況フラグ
     * @return 認定調査票（概況調査）サービスの状況フラグビルダー
     */
    public NinteichosahyoServiceJokyoFlagBuilder 認定調査票概況調査サービスの状況フラグの編集(dgNinteiChosaData_Row row, NinteichosahyoServiceJokyoFlag entity) {

        NinteichosahyoServiceJokyoFlagBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getServiceJokyoFlagRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.setサービスの状況フラグ(Boolean.getBoolean(row.getServiceJokyoFlag().toString()));
        return builder;
    }

    /**
     * 認定調査票概況調査記入項目の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）記入項目
     * @return 認定調査票（概況調査）記入項目ビルダー
     */
    public NinteichosahyoKinyuItemBuilder 認定調査票概況調査記入項目の編集(dgNinteiChosaData_Row row, NinteichosahyoKinyuItem entity) {

        NinteichosahyoKinyuItemBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getServiceJokyoKinyuRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.setサービスの状況記入(row.getServiceJokyoKinyu());
        return builder;
    }

    /**
     * 認定調査票概況調査施設利用の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）施設利用
     * @return 認定調査票（概況調査）施設利用ビルダー
     */
    public NinteichosahyoShisetsuRiyoBuilder 認定調査票概況調査施設利用の編集(dgNinteiChosaData_Row row, NinteichosahyoShisetsuRiyo entity) {

        NinteichosahyoShisetsuRiyoBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getShisetsuRiyoFlagRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set施設利用フラグ(Boolean.getBoolean(row.getShisetsuRiyoFlag().toString()));
        return builder;
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }
}
