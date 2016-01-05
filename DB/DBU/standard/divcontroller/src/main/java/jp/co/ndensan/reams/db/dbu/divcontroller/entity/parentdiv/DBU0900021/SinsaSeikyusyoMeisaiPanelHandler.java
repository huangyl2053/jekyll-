package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.SinsaSeikyusyoTorokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SinsaSeikyusyoMeisaiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.HihokenshaKankeiCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 審査請求書登録_登録DivのHandlerクラスです。
 */
public class SinsaSeikyusyoMeisaiPanelHandler {

    private final SinsaSeikyusyoMeisaiPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 審査請求書登録_登録Divのエンティティ
     */
    public SinsaSeikyusyoMeisaiPanelHandler(SinsaSeikyusyoMeisaiPanelDiv div) {
        this.div = div;
    }

    /**
     * 審査請求書登録の初期化。(追加)
     *
     */
    public void 追加_初期化の編集() {

        div.getRadTenpuShorui().setSelectedKey(new RString("key1"));
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setDataSource(get被保険者との関係ドロップダウンリスト());
        div.getSyobunJohoPanel().getDdlShobuShurui().setDataSource(get処分種類コードドロップダウンリスト());
    }

    /**
     * 審査請求書登録の初期化。(修正)
     *
     * @param sinsaSeikyusyoMeisaiJohoEntity 審査請求書登録明細情報
     */
    public void 修正_初期化の編集(SinsaSeikyusyoMeisaiJoho sinsaSeikyusyoMeisaiJohoEntity) {

        if (sinsaSeikyusyoMeisaiJohoEntity.get審査請求届出日() != null) {
            div.getMeisaiPanel().getTxtdateTodokedebi().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get審査請求届出日().toString()));
        }
        div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().setValue(sinsaSeikyusyoMeisaiJohoEntity.get審査請求人郵便番号());
        div.getSinsaSeikyuninJohoPanel().getTxtJusho().setDomain(new AtenaJusho(sinsaSeikyusyoMeisaiJohoEntity
                .get審査請求人住所() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get審査請求人住所().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().setDomain(new AtenaMeisho(sinsaSeikyusyoMeisaiJohoEntity.
                get審査請求人氏名() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get審査請求人氏名().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtTelNo().setDomain(new TelNo(sinsaSeikyusyoMeisaiJohoEntity
                .get審査請求人電話番号() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get審査請求人電話番号().value()));
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setDataSource(get被保険者との関係ドロップダウンリスト());
        div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().setValue(sinsaSeikyusyoMeisaiJohoEntity.get被保険者との関係());
        div.getDaiiniJohoPanel().getTxtDairiYubinNo().setValue(sinsaSeikyusyoMeisaiJohoEntity.get代理人郵便番号());
        div.getDaiiniJohoPanel().getTxtDairiJusho().setDomain(new AtenaJusho(sinsaSeikyusyoMeisaiJohoEntity
                .get代理人住所() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get代理人住所().value()));
        div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().setDomain(new AtenaMeisho(sinsaSeikyusyoMeisaiJohoEntity
                .get代理人氏名() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get代理人氏名().value()));
        div.getDaiiniJohoPanel().getTxtDairiTelNo().setDomain(new TelNo(sinsaSeikyusyoMeisaiJohoEntity.
                get代理人電話番号() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get代理人電話番号().value()));
        if (sinsaSeikyusyoMeisaiJohoEntity.get処分日() != null) {
            div.getSyobunJohoPanel().getTxtShobubi().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get処分日().toString()));
        }
        div.getSyobunJohoPanel().getTxtShobucho().setValue(sinsaSeikyusyoMeisaiJohoEntity.get処分庁());
        div.getSyobunJohoPanel().getDdlShobuShurui().setDataSource(get処分種類コードドロップダウンリスト());
        if (sinsaSeikyusyoMeisaiJohoEntity.get処分があったことを知った日() != null) {
            div.getSyobunJohoPanel().getTxtShobuShitaNichi().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get処分があったことを知った日().toString()));
        }
        div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().setValue(sinsaSeikyusyoMeisaiJohoEntity.get審査請求の理由());
        div.getMeisaiPanel().getTxtKyoshiNaiyo().setValue(sinsaSeikyusyoMeisaiJohoEntity.get審査請求の理由());
        if (sinsaSeikyusyoMeisaiJohoEntity.get添付書類等()) {
            div.getRadTenpuShorui().setSelectedKey(new RString("key0"));
        } else {
            div.getRadTenpuShorui().setSelectedKey(new RString("key1"));
        }
        if (sinsaSeikyusyoMeisaiJohoEntity.get審査請求取下日() != null) {
            div.getTxtShinsaSeikyuTorisage().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get審査請求取下日().toString()));
        }
    }

    /**
     * 審査請求書登録の初期化。(削除)
     *
     * @param sinsaSeikyusyoMeisaiJohoEntity 審査請求書登録明細情報
     */
    public void 削除_初期化の編集(SinsaSeikyusyoMeisaiJoho sinsaSeikyusyoMeisaiJohoEntity) {

        if (sinsaSeikyusyoMeisaiJohoEntity.get審査請求届出日() != null) {
            div.getMeisaiPanel().getTxtdateTodokedebi().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get審査請求届出日().toString()));
        }
        div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().setValue(sinsaSeikyusyoMeisaiJohoEntity.get審査請求人郵便番号());
        div.getSinsaSeikyuninJohoPanel().getTxtJusho().setDomain(new AtenaJusho(sinsaSeikyusyoMeisaiJohoEntity
                .get審査請求人住所() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get審査請求人住所().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().setDomain(new AtenaMeisho(sinsaSeikyusyoMeisaiJohoEntity.
                get審査請求人氏名() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get審査請求人氏名().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtTelNo().setDomain(new TelNo(sinsaSeikyusyoMeisaiJohoEntity
                .get審査請求人電話番号() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get審査請求人電話番号().value()));
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setDataSource(get被保険者との関係ドロップダウンリスト());
        div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().setValue(sinsaSeikyusyoMeisaiJohoEntity.get被保険者との関係());
        div.getDaiiniJohoPanel().getTxtDairiYubinNo().setValue(sinsaSeikyusyoMeisaiJohoEntity.get代理人郵便番号());
        div.getDaiiniJohoPanel().getTxtDairiJusho().setDomain(new AtenaJusho(sinsaSeikyusyoMeisaiJohoEntity
                .get代理人住所() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get代理人住所().value()));
        div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().setDomain(new AtenaMeisho(sinsaSeikyusyoMeisaiJohoEntity
                .get代理人氏名() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get代理人氏名().value()));
        div.getDaiiniJohoPanel().getTxtDairiTelNo().setDomain(new TelNo(sinsaSeikyusyoMeisaiJohoEntity.
                get代理人電話番号() == null ? RString.EMPTY : sinsaSeikyusyoMeisaiJohoEntity.get代理人電話番号().value()));
        if (sinsaSeikyusyoMeisaiJohoEntity.get処分日() != null) {
            div.getSyobunJohoPanel().getTxtShobubi().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get処分日().toString()));
        }
        div.getSyobunJohoPanel().getTxtShobucho().setValue(sinsaSeikyusyoMeisaiJohoEntity.get処分庁());
        div.getSyobunJohoPanel().getDdlShobuShurui().setDataSource(get処分種類コードドロップダウンリスト());
        if (sinsaSeikyusyoMeisaiJohoEntity.get処分があったことを知った日() != null) {
            div.getSyobunJohoPanel().getTxtShobuShitaNichi().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get処分があったことを知った日().toString()));
        }
        div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().setValue(sinsaSeikyusyoMeisaiJohoEntity.get審査請求の理由());
        div.getMeisaiPanel().getTxtKyoshiNaiyo().setValue(sinsaSeikyusyoMeisaiJohoEntity.get審査請求の理由());
        if (sinsaSeikyusyoMeisaiJohoEntity.get添付書類等()) {
            div.getRadTenpuShorui().setSelectedKey(new RString("key0"));
        } else {
            div.getRadTenpuShorui().setSelectedKey(new RString("key1"));
        }
        if (sinsaSeikyusyoMeisaiJohoEntity.get審査請求取下日() != null) {
            div.getTxtShinsaSeikyuTorisage().setValue(new RDate(sinsaSeikyusyoMeisaiJohoEntity.get審査請求取下日().toString()));
        }
        削除状態の非活性();
    }

    /**
     * 調査員情報登録エリアの初期画面値の保持。
     *
     */
    public void 初期画面値の保持() {
        RString 修正前の値 = div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().getValue().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtJusho().getDomain().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().getDomain().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtTelNo().getDomain().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().getSelectedValue())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().getValue())
                .concat(div.getDaiiniJohoPanel().getTxtDairiYubinNo().getValue().value())
                .concat(div.getDaiiniJohoPanel().getTxtDairiJusho().getDomain().value())
                .concat(div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().getDomain().value())
                .concat(div.getDaiiniJohoPanel().getTxtDairiTelNo().getDomain().value())
                .concat(div.getSyobunJohoPanel().getTxtShobubi().getValue() == null
                        ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobubi().getValue().toDateString())
                .concat(div.getSyobunJohoPanel().getTxtShobucho().getValue())
                .concat(div.getSyobunJohoPanel().getDdlShobuShurui().getSelectedValue())
                .concat(div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue() == null
                        ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue().toDateString())
                .concat(div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().getValue())
                .concat(div.getMeisaiPanel().getTxtKyoshiNaiyo().getValue())
                .concat(div.getRadTenpuShorui().getSelectedValue())
                .concat(div.getTxtShinsaSeikyuTorisage().getValue() == null
                        ? RString.EMPTY : div.getTxtShinsaSeikyuTorisage().getValue().toDateString());
        div.set修正前の値(DataPassingConverter.serialize(修正前の値));
    }

    /**
     * 調査員情報登録エリアの初期画面値の保持。
     *
     * @return 修正後の値
     */
    public RString 修正後の値() {
        return div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().getValue().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtJusho().getDomain().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().getDomain().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtTelNo().getDomain().value())
                .concat(div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().getSelectedValue())
                .concat(div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().getValue())
                .concat(div.getDaiiniJohoPanel().getTxtDairiYubinNo().getValue().value())
                .concat(div.getDaiiniJohoPanel().getTxtDairiJusho().getDomain().value())
                .concat(div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().getDomain().value())
                .concat(div.getDaiiniJohoPanel().getTxtDairiTelNo().getDomain().value())
                .concat(div.getSyobunJohoPanel().getTxtShobubi().getValue() == null
                        ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobubi().getValue().toDateString())
                .concat(div.getSyobunJohoPanel().getTxtShobucho().getValue())
                .concat(div.getSyobunJohoPanel().getDdlShobuShurui().getSelectedValue())
                .concat(div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue() == null
                        ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue().toDateString())
                .concat(div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().getValue())
                .concat(div.getMeisaiPanel().getTxtKyoshiNaiyo().getValue())
                .concat(div.getRadTenpuShorui().getSelectedValue())
                .concat(div.getTxtShinsaSeikyuTorisage().getValue() == null
                        ? RString.EMPTY : div.getTxtShinsaSeikyuTorisage().getValue().toDateString());
    }

    /**
     * 審査請求書登録の編集。
     *
     * @param entity 不服審査申立情報
     */
    public void 審査請求書登録の編集(DbT7001FufukuMoshitateEntity entity) {

        entity.setShikibetsuCode(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        entity.setGenshobunsHihokennshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        entity.setShinsaSeikyuTodokedeYMD(new FlexibleDate(div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()));
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        entity.setShichosonCode(association.get地方公共団体コード());
        entity.setShinsaSeikyuninYubinNo(div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().getValue());
        entity.setShinsaSeikyuninJusho(div.getSinsaSeikyuninJohoPanel().getTxtJusho().getDomain());
        entity.setShinsaSeikyuninShimei(div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().getDomain());
        entity.setShinsaSeikyuninTelNo(div.getSinsaSeikyuninJohoPanel().getTxtTelNo().getDomain());
        entity.setHihokenshaTonoKankeiCode(div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().getSelectedKey());
        entity.setHihokenshaTonoKankei(div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().getValue());
        entity.setDairininYubinNo(div.getDaiiniJohoPanel().getTxtDairiYubinNo().getValue());
        entity.setDairininJusho(div.getDaiiniJohoPanel().getTxtDairiJusho().getDomain());
        entity.setDairininShimei(div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().getDomain());
        entity.setDairininTelNo(div.getDaiiniJohoPanel().getTxtDairiTelNo().getDomain());
        entity.setShobunCho(div.getSyobunJohoPanel().getTxtShobucho().getValue());
        entity.setShobunYMD(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobubi().getValue().toDateString()));
        entity.setShobunShuruiCode(div.getSyobunJohoPanel().getDdlShobuShurui().getSelectedKey());
        entity.setShobunKakuninYMD(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue().toDateString()));
        entity.setShinsaSeikyuRiyu(div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().getValue());
        entity.setShobunChoKyojiNaiyo(div.getMeisaiPanel().getTxtKyoshiNaiyo().getValue());
        if (new RString("key0").equals(div.getRadTenpuShorui().getSelectedKey())) {
            entity.setTempuShoruiTo(true);
        } else {
            entity.setTempuShoruiTo(false);
        }
        entity.setShinsaSeikyuTorisageYMD(new FlexibleDate(div.getTxtShinsaSeikyuTorisage().getValue().toDateString()));
        entity.setBemmeishoTorokuFlag(false);
    }

    /**
     * 審査請求書削除の編集。
     *
     * @param entity 不服審査申立情報
     */
    public void 審査請求書削除の編集(SinsaSeikyusyoTorokuEntity entity) {

        entity.setShikibetsuCode(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        entity.setGenshobunsHihokennshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        entity.setShinsaSeikyuTodokedeYMD(new FlexibleDate(div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()));
    }

    /**
     * 審査請求書更新の編集。
     *
     * @param entity 不服審査申立情報
     */
    public void 審査請求書更新の編集(SinsaSeikyusyoTorokuEntity entity) {

        entity.setShikibetsuCode(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        entity.setGenshobunsHihokennshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        entity.setShinsaSeikyuTodokedeYMD(new FlexibleDate(div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()));
        entity.setShinsaSeikyuninYubinNo(div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().getValue());
        entity.setShinsaSeikyuninJusho(div.getSinsaSeikyuninJohoPanel().getTxtJusho().getDomain());
        entity.setShinsaSeikyuninShimei(div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().getDomain());
        entity.setShinsaSeikyuninTelNo(div.getSinsaSeikyuninJohoPanel().getTxtTelNo().getDomain());
        entity.setHihokenshaTonoKankeiCode(div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().getSelectedKey());
        entity.setHihokenshaTonoKankei(div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().getValue());
        entity.setDairininYubinNo(div.getDaiiniJohoPanel().getTxtDairiYubinNo().getValue());
        entity.setDairininJusho(div.getDaiiniJohoPanel().getTxtDairiJusho().getDomain());
        entity.setDairininShimei(div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().getDomain());
        entity.setDairininTelNo(div.getDaiiniJohoPanel().getTxtDairiTelNo().getDomain());
        entity.setShobunCho(div.getSyobunJohoPanel().getTxtShobucho().getValue());
        entity.setShobunYMD(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobubi().getValue().toDateString()));
        entity.setShobunShuruiCode(div.getSyobunJohoPanel().getDdlShobuShurui().getSelectedKey());
        entity.setShobunKakuninYMD(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue().toDateString()));
        entity.setShinsaSeikyuRiyu(div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().getValue());
        entity.setShobunChoKyojiNaiyo(div.getMeisaiPanel().getTxtKyoshiNaiyo().getValue());
        if (new RString("key0").equals(div.getRadTenpuShorui().getSelectedKey())) {
            entity.setTempuShoruiTo(true);
        } else {
            entity.setTempuShoruiTo(false);
        }
        entity.setShinsaSeikyuTorisageYMD(new FlexibleDate(div.getTxtShinsaSeikyuTorisage().getValue().toDateString()));
    }

    private List<KeyValueDataSource> get被保険者との関係ドロップダウンリスト() {

        List<KeyValueDataSource> dataSourceList = new ArrayList();

        for (HihokenshaKankeiCode type : HihokenshaKankeiCode.values()) {

            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(type.getコード());
            dataSource.setValue(type.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private void 削除状態の非活性() {

        div.getMeisaiPanel().getTxtdateTodokedebi().setDisabled(true);
        div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().setDisabled(true);
        div.getSinsaSeikyuninJohoPanel().getTxtJusho().setDisabled(true);
        div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().setDisabled(true);
        div.getSinsaSeikyuninJohoPanel().getTxtTelNo().setDisabled(true);
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setDisabled(true);
        div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().setDisabled(true);
        div.getDaiiniJohoPanel().getTxtDairiYubinNo().setDisabled(true);
        div.getDaiiniJohoPanel().getTxtDairiJusho().setDisabled(true);
        div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().setDisabled(true);
        div.getDaiiniJohoPanel().getTxtDairiTelNo().setDisabled(true);
        div.getSyobunJohoPanel().getTxtShobubi().setDisabled(true);
        div.getSyobunJohoPanel().getTxtShobucho().setDisabled(true);
        div.getSyobunJohoPanel().getDdlShobuShurui().setDisabled(true);
        div.getSyobunJohoPanel().getTxtShobuShitaNichi().setDisabled(true);
        div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().setDisabled(true);
        div.getMeisaiPanel().getTxtKyoshiNaiyo().setDisabled(true);
        div.getRadTenpuShorui().setDisabled(true);
        div.getTxtShinsaSeikyuTorisage().setDisabled(true);
    }

    private List<KeyValueDataSource> get処分種類コードドロップダウンリスト() {

        List<KeyValueDataSource> dataSourceList = new ArrayList();

        for (ShobunShuruiCode type : ShobunShuruiCode.values()) {

            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(type.getコード());
            dataSource.setValue(type.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }
}
