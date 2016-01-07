package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0210011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021.*;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitateBuilder;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.HihokenshaKankeiCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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
     * @param fufukuMoshitate 審査請求書登録明細情報
     */
    public void 修正_初期化の編集(FufukuMoshitate fufukuMoshitate) {

        if (fufukuMoshitate.get審査請求届出日() != null && !fufukuMoshitate.get審査請求届出日().isEmpty()) {
            div.getMeisaiPanel().getTxtdateTodokedebi().setValue(new RDate(fufukuMoshitate.get審査請求届出日().toString()));
        }
        div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().setValue(fufukuMoshitate.get審査請求人郵便番号());
        div.getSinsaSeikyuninJohoPanel().getTxtJusho().setDomain(new AtenaJusho(fufukuMoshitate
                .get審査請求人住所() == null ? RString.EMPTY : fufukuMoshitate.get審査請求人住所().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().setDomain(new AtenaMeisho(fufukuMoshitate.
                get審査請求人氏名() == null ? RString.EMPTY : fufukuMoshitate.get審査請求人氏名().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtTelNo().setDomain(new TelNo(fufukuMoshitate
                .get審査請求人電話番号() == null ? RString.EMPTY : fufukuMoshitate.get審査請求人電話番号().value()));
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setDataSource(get被保険者との関係ドロップダウンリスト());
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setSelectedKey(fufukuMoshitate.get被保険者との関係コード()
                == null ? RString.EMPTY : fufukuMoshitate.get被保険者との関係コード());
        div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().setValue(fufukuMoshitate.get被保険者との関係());
        div.getDaiiniJohoPanel().getTxtDairiYubinNo().setValue(fufukuMoshitate.get代理人郵便番号());
        div.getDaiiniJohoPanel().getTxtDairiJusho().setDomain(new AtenaJusho(fufukuMoshitate
                .get代理人住所() == null ? RString.EMPTY : fufukuMoshitate.get代理人住所().value()));
        div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().setDomain(new AtenaMeisho(fufukuMoshitate
                .get代理人氏名() == null ? RString.EMPTY : fufukuMoshitate.get代理人氏名().value()));
        div.getDaiiniJohoPanel().getTxtDairiTelNo().setDomain(new TelNo(fufukuMoshitate.
                get代理人電話番号() == null ? RString.EMPTY : fufukuMoshitate.get代理人電話番号().value()));
        if (fufukuMoshitate.get処分日() != null && !fufukuMoshitate.get処分日().isEmpty()) {
            div.getSyobunJohoPanel().getTxtShobubi().setValue(new RDate(fufukuMoshitate.get処分日().toString()));
        }
        div.getSyobunJohoPanel().getTxtShobucho().setValue(fufukuMoshitate.get処分庁());
        div.getSyobunJohoPanel().getDdlShobuShurui().setDataSource(get処分種類コードドロップダウンリスト());
        div.getSyobunJohoPanel().getDdlShobuShurui().setSelectedKey(fufukuMoshitate.
                get処分種類コード() == null ? RString.EMPTY : fufukuMoshitate.get処分種類コード());
        if (fufukuMoshitate.get処分があったことを知った日() != null && !fufukuMoshitate.get処分があったことを知った日().isEmpty()) {
            div.getSyobunJohoPanel().getTxtShobuShitaNichi().setValue(new RDate(fufukuMoshitate.get処分があったことを知った日().toString()));
        }
        div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().setValue(fufukuMoshitate.get審査請求の理由());
        div.getMeisaiPanel().getTxtKyoshiNaiyo().setValue(fufukuMoshitate.get処分庁教示の有無及び教示の内容());
        if (fufukuMoshitate.is添付書類等()) {
            div.getRadTenpuShorui().setSelectedKey(new RString("key0"));
        } else {
            div.getRadTenpuShorui().setSelectedKey(new RString("key1"));
        }
        if (fufukuMoshitate.get審査請求取下日() != null && !fufukuMoshitate.get審査請求取下日().isEmpty()) {
            div.getTxtShinsaSeikyuTorisage().setValue(new RDate(fufukuMoshitate.get審査請求取下日().toString()));
        }
    }

    /**
     * 審査請求書登録の初期化。(削除)
     *
     * @param fufukuMoshitate 審査請求書登録明細情報
     */
    public void 削除_初期化の編集(FufukuMoshitate fufukuMoshitate) {

        if (fufukuMoshitate.get審査請求届出日() != null && !fufukuMoshitate.get審査請求届出日().isEmpty()) {
            div.getMeisaiPanel().getTxtdateTodokedebi().setValue(new RDate(fufukuMoshitate.get審査請求届出日().toString()));
        }
        div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().setValue(fufukuMoshitate.get審査請求人郵便番号());
        div.getSinsaSeikyuninJohoPanel().getTxtJusho().setDomain(new AtenaJusho(fufukuMoshitate
                .get審査請求人住所() == null ? RString.EMPTY : fufukuMoshitate.get審査請求人住所().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().setDomain(new AtenaMeisho(fufukuMoshitate.
                get審査請求人氏名() == null ? RString.EMPTY : fufukuMoshitate.get審査請求人氏名().value()));
        div.getSinsaSeikyuninJohoPanel().getTxtTelNo().setDomain(new TelNo(fufukuMoshitate
                .get審査請求人電話番号() == null ? RString.EMPTY : fufukuMoshitate.get審査請求人電話番号().value()));
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setDataSource(get被保険者との関係ドロップダウンリスト());
        div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().setSelectedKey(fufukuMoshitate.
                get被保険者との関係コード() == null ? RString.EMPTY : fufukuMoshitate.get被保険者との関係コード());
        div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().setValue(fufukuMoshitate.get被保険者との関係());
        div.getDaiiniJohoPanel().getTxtDairiYubinNo().setValue(fufukuMoshitate.get代理人郵便番号());
        div.getDaiiniJohoPanel().getTxtDairiJusho().setDomain(new AtenaJusho(fufukuMoshitate
                .get代理人住所() == null ? RString.EMPTY : fufukuMoshitate.get代理人住所().value()));
        div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().setDomain(new AtenaMeisho(fufukuMoshitate
                .get代理人氏名() == null ? RString.EMPTY : fufukuMoshitate.get代理人氏名().value()));
        div.getDaiiniJohoPanel().getTxtDairiTelNo().setDomain(new TelNo(fufukuMoshitate.
                get代理人電話番号() == null ? RString.EMPTY : fufukuMoshitate.get代理人電話番号().value()));
        if (fufukuMoshitate.get処分日() != null && !fufukuMoshitate.get処分日().isEmpty()) {
            div.getSyobunJohoPanel().getTxtShobubi().setValue(new RDate(fufukuMoshitate.get処分日().toString()));
        }
        div.getSyobunJohoPanel().getTxtShobucho().setValue(fufukuMoshitate.get処分庁());
        div.getSyobunJohoPanel().getDdlShobuShurui().setDataSource(get処分種類コードドロップダウンリスト());
        div.getSyobunJohoPanel().getDdlShobuShurui().setSelectedKey(fufukuMoshitate.
                get処分種類コード() == null ? RString.EMPTY : fufukuMoshitate.get処分種類コード());
        if (fufukuMoshitate.get処分があったことを知った日() != null && !fufukuMoshitate.get処分があったことを知った日().isEmpty()) {
            div.getSyobunJohoPanel().getTxtShobuShitaNichi().setValue(new RDate(fufukuMoshitate.get処分があったことを知った日().toString()));
        }
        div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().setValue(fufukuMoshitate.get審査請求の理由());
        div.getMeisaiPanel().getTxtKyoshiNaiyo().setValue(fufukuMoshitate.get処分庁教示の有無及び教示の内容());
        if (fufukuMoshitate.is添付書類等()) {
            div.getRadTenpuShorui().setSelectedKey(new RString("key0"));
        } else {
            div.getRadTenpuShorui().setSelectedKey(new RString("key1"));
        }
        if (fufukuMoshitate.get審査請求取下日() != null && !fufukuMoshitate.get審査請求取下日().isEmpty()) {
            div.getTxtShinsaSeikyuTorisage().setValue(new RDate(fufukuMoshitate.get審査請求取下日().toString()));
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
     * @param fufukuMoshitate 不服審査申立情報
     * @return FufukuMoshitate
     */
    public FufukuMoshitate 審査請求書登録の編集(FufukuMoshitate fufukuMoshitate) {

        FufukuMoshitateBuilder fufukuMoshitateBuilder = fufukuMoshitate.createBuilderForEdit();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        fufukuMoshitateBuilder.set市町村コード(association.get地方公共団体コード());
        fufukuMoshitateBuilder.set審査請求人郵便番号(div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().getValue());
        fufukuMoshitateBuilder.set審査請求人住所(div.getSinsaSeikyuninJohoPanel().getTxtJusho().getDomain());
        fufukuMoshitateBuilder.set審査請求人氏名(div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().getDomain());
        fufukuMoshitateBuilder.set審査請求人電話番号(div.getSinsaSeikyuninJohoPanel().getTxtTelNo().getDomain());
        fufukuMoshitateBuilder.set被保険者との関係コード(div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().getSelectedKey());
        fufukuMoshitateBuilder.set被保険者との関係(div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().getValue());
        fufukuMoshitateBuilder.set代理人郵便番号(div.getDaiiniJohoPanel().getTxtDairiYubinNo().getValue());
        fufukuMoshitateBuilder.set代理人住所(div.getDaiiniJohoPanel().getTxtDairiJusho().getDomain());
        fufukuMoshitateBuilder.set代理人氏名(div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().getDomain());
        fufukuMoshitateBuilder.set代理人電話番号(div.getDaiiniJohoPanel().getTxtDairiTelNo().getDomain());
        fufukuMoshitateBuilder.set処分庁(div.getSyobunJohoPanel().getTxtShobucho().getValue());
        fufukuMoshitateBuilder.set処分日(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobubi().getValue() == null
                ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobubi().getValue().toDateString()));
        fufukuMoshitateBuilder.set処分種類コード(div.getSyobunJohoPanel().getDdlShobuShurui().getSelectedKey());
        fufukuMoshitateBuilder.set処分があったことを知った日(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue() == null
                ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue().toDateString()));
        fufukuMoshitateBuilder.set審査請求の理由(div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().getValue());
        fufukuMoshitateBuilder.set処分庁教示の有無及び教示の内容(div.getMeisaiPanel().getTxtKyoshiNaiyo().getValue());
        if (new RString("key0").equals(div.getRadTenpuShorui().getSelectedKey())) {
            fufukuMoshitateBuilder.set添付書類等(true);
        } else {
            fufukuMoshitateBuilder.set添付書類等(false);
        }
        fufukuMoshitateBuilder.set審査請求取下日(new FlexibleDate(div.getTxtShinsaSeikyuTorisage().getValue() == null
                ? RString.EMPTY : div.getTxtShinsaSeikyuTorisage().getValue().toDateString()));
        fufukuMoshitateBuilder.set弁明書登録フラグ(false);
        return fufukuMoshitateBuilder.build();
    }

    /**
     * 審査請求書更新の編集。
     *
     * @param fufukuMoshitate 不服審査申立情報
     * @return FufukuMoshitate
     */
    public FufukuMoshitate 審査請求書更新の編集(FufukuMoshitate fufukuMoshitate) {

        FufukuMoshitateBuilder fufukuMoshitateBuilder = fufukuMoshitate.createBuilderForEdit();
        fufukuMoshitateBuilder.set審査請求人郵便番号(div.getSinsaSeikyuninJohoPanel().getTxtYubinNo().getValue());
        fufukuMoshitateBuilder.set審査請求人住所(div.getSinsaSeikyuninJohoPanel().getTxtJusho().getDomain());
        fufukuMoshitateBuilder.set審査請求人氏名(div.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei().getDomain());
        fufukuMoshitateBuilder.set審査請求人電話番号(div.getSinsaSeikyuninJohoPanel().getTxtTelNo().getDomain());
        fufukuMoshitateBuilder.set被保険者との関係コード(div.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko().getSelectedKey());
        fufukuMoshitateBuilder.set被保険者との関係(div.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken().getValue());
        fufukuMoshitateBuilder.set代理人郵便番号(div.getDaiiniJohoPanel().getTxtDairiYubinNo().getValue());
        fufukuMoshitateBuilder.set代理人住所(div.getDaiiniJohoPanel().getTxtDairiJusho().getDomain());
        fufukuMoshitateBuilder.set代理人氏名(div.getDaiiniJohoPanel().getTxtDairiJinJohoShimei().getDomain());
        fufukuMoshitateBuilder.set代理人電話番号(div.getDaiiniJohoPanel().getTxtDairiTelNo().getDomain());
        fufukuMoshitateBuilder.set処分庁(div.getSyobunJohoPanel().getTxtShobucho().getValue());
        fufukuMoshitateBuilder.set処分日(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobubi().getValue() == null
                ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobubi().getValue().toDateString()));
        fufukuMoshitateBuilder.set処分種類コード(div.getSyobunJohoPanel().getDdlShobuShurui().getSelectedKey());
        fufukuMoshitateBuilder.set処分があったことを知った日(new FlexibleDate(div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue() == null
                ? RString.EMPTY : div.getSyobunJohoPanel().getTxtShobuShitaNichi().getValue().toDateString()));
        fufukuMoshitateBuilder.set審査請求の理由(div.getMeisaiPanel().getTxtShinsaSeikyuRiyu().getValue());
        fufukuMoshitateBuilder.set処分庁教示の有無及び教示の内容(div.getMeisaiPanel().getTxtKyoshiNaiyo().getValue());
        if (new RString("key0").equals(div.getRadTenpuShorui().getSelectedKey())) {
            fufukuMoshitateBuilder.set添付書類等(true);
        } else {
            fufukuMoshitateBuilder.set添付書類等(false);
        }
        fufukuMoshitateBuilder.set審査請求取下日(new FlexibleDate(div.getTxtShinsaSeikyuTorisage().getValue() == null
                ? RString.EMPTY : div.getTxtShinsaSeikyuTorisage().getValue().toDateString()));
        return fufukuMoshitateBuilder.build().modifiedModel();
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
