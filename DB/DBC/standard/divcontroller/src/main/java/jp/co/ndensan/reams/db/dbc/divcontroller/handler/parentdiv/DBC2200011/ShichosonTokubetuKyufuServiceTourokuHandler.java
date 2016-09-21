/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuServiceBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.shichosontokubetukyufuservice.ShichosonTokubetuKyufuServiceEntityResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.dgServiceNaiyo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShichosonTokubetuKyufuServiceManager;
import jp.co.ndensan.reams.db.dbc.service.core.shichosontokubetukyufuservice.ShichosonTokubetuKyufuServiceFinder;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBC2200011_市町村特別給付サービス内容登録のHandlerクラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public class ShichosonTokubetuKyufuServiceTourokuHandler {

    private final ShichosonTokubetuKyufuServiceTourokuDiv div;
    private static final RString 単位コード = new RString("0");
    private static final RString 単位 = new RString("単位");
    private static final RString 日数コード = new RString("1");
    private static final RString 日数 = new RString("日数");
    private static final RString サービスコード固定値 = new RString("81");
    private ShichosonTokubetuKyufuServiceEntityResult 明細エリア初期値 = null;
    private static final RString 削除やめる = new RString("btnSaikujoCancel");
    private static final RString 追加やめる = new RString("btnTsuikaCancel");
    private static final RString 修正やめる = new RString("btnShuseiCancel");
    private static final RString 保存する = new RString("btnUpdate");

    /**
     * コンストラクタです。
     *
     * @param div ShichosonTokubetuKyufuServiceFinderTourokuDiv
     */
    public ShichosonTokubetuKyufuServiceTourokuHandler(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {
        ShichosonTokubetuKyufuServiceFinder service = ShichosonTokubetuKyufuServiceFinder.createInstance();
        List<ShichosonTokubetuKyufuServiceEntityResult> 市町村特別給付サービス内容一覧情報 = service.get一覧情報();
        if (市町村特別給付サービス内容一覧情報 != null && !市町村特別給付サービス内容一覧情報.isEmpty()) {
            List<dgServiceNaiyo_Row> dataSource = new ArrayList<>();
            for (ShichosonTokubetuKyufuServiceEntityResult entity : 市町村特別給付サービス内容一覧情報) {
                dgServiceNaiyo_Row row = new dgServiceNaiyo_Row();
                row.setServiceCode(entity.getサービスコード());
                row.setServiceYukoKikanKaishiYMD(entity.get有効期間開始年月日().wareki().toDateString());
                row.setServiceYukoKikanShuryoYMD(entity.get有効期間終了年月日().wareki().toDateString());
                row.setServiceSeishikiName(entity.get正式名称());
                if (単位コード.equals(entity.getサービス区分())) {
                    row.setServiceKubun(単位);
                } else if (日数コード.equals(entity.getサービス区分())) {
                    row.setServiceKubun(日数);
                }
                row.setTanisuNissu(new RString(entity.get単位().toString()));
                row.setShikyuGendogaku(new RString(entity.get支給限度基準額().toString()));
                row.setServiceRyakushoName(entity.get略称());
                row.setRirekiNo(new RString(entity.get履歴番号()));
                row.setChokkinFlag(entity.get直近フラグ());
                row.getServiceYukoKikanKaishiYMDSeireki().setValue(entity.get有効期間開始年月日().toRDate());
                row.getServiceYukoKikanShuryoYMDSeireki().setValue(entity.get有効期間終了年月日().toRDate());
                dataSource.add(row);
            }
            div.getDgServiceNaiyo().setDataSource(dataSource);

            ShichosonTokubetuKyufuServiceEntityResult 明細Entity = 市町村特別給付サービス内容一覧情報.get(0);
            明細エリア初期値 = 明細Entity;
            initialize明細エリア(明細Entity);

            LockingKey 排他キー = new LockingKey(明細Entity.getサービスコード(),
                    明細Entity.get有効期間開始年月日(), 明細Entity.get履歴番号());
            RealInitialLocker.lock(排他キー);
        }
        initialize照会モード();
    }

    /**
     * 画面修正モード表示のメソッドます。
     */
    public void initialize修正モード() {
        div.getBtnTsuika().setDisabled(true);
        div.getDgServiceNaiyo().setDisabled(true);

        div.getKubunShikyuGendogakuShosai().getTxtServiceCode1().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getRadKubun().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTanni().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().setDisabled(false);

        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(削除やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(追加やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(修正やめる, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, false);
    }

    /**
     * 画面削除モード表示のメソッドます。
     */
    public void initialize削除モード() {
        div.getBtnTsuika().setDisabled(true);
        div.getDgServiceNaiyo().setDisabled(true);

        div.getKubunShikyuGendogakuShosai().getTxtServiceCode1().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getRadKubun().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtTanni().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().setDisabled(true);

        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(削除やめる, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(追加やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(修正やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, false);
    }

    /**
     * 画面追加モード表示のメソッドます。
     */
    public void initialize追加モード() {
        div.getBtnTsuika().setDisabled(true);
        div.getDgServiceNaiyo().setDisabled(true);

        div.getKubunShikyuGendogakuShosai().getTxtServiceCode1().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getRadKubun().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtTanni().setDisabled(false);
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().setDisabled(false);

        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(削除やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(追加やめる, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(修正やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, false);
    }

    /**
     * 一覧の行選択処理です。
     */
    public void onSelect() {
        initialize照会モード();
        選択行データ処理();
    }

    /**
     * 画面照会モード表示のメソッドます。
     */
    public void initialize照会モード() {
        div.getBtnTsuika().setDisabled(false);
        div.getDgServiceNaiyo().setDisabled(false);

        div.getKubunShikyuGendogakuShosai().getTxtServiceCode1().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getRadKubun().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtTanni().setDisabled(true);
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().setDisabled(true);

        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(削除やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(追加やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(修正やめる, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
    }

    /**
     * DB登録処理。
     */
    public void save() {
        ShichosonTokubetuKyufuServiceManager manager = new ShichosonTokubetuKyufuServiceManager();
        ShichosonTokubetuKyufuServiceFinder finder = ShichosonTokubetuKyufuServiceFinder.createInstance();
        if (!CommonButtonHolder.isDisplayNone(追加やめる)) {
            RString serviceCode = サービスコード固定値.concat(div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().getValue());
            int 最大履歴番号 = finder.get最大履歴番号(serviceCode);
            ShichosonTokubetuKyufuService entity = new ShichosonTokubetuKyufuService(serviceCode,
                    div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue().toFlexibleDate(),
                    最大履歴番号 + 1);
            ShichosonTokubetuKyufuServiceBuilder builder = entity.createBuilderForEdit();
            builder.set市町村特別給付用サービスコード(serviceCode);
            builder.set市町村特別給付用サービス名_正式名称(div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue());
            builder.set市町村特別給付用サービス名_略称(div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue());
            builder.set市町村特別給付用サービス有効期間開始年月日(div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue().toFlexibleDate());
            builder.set市町村特別給付用サービス有効期間終了年月日(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue().toFlexibleDate());
            builder.set市町村特別給付用サービス区分(div.getKubunShikyuGendogakuShosai().getRadKubun().getSelectedKey());
            builder.set市町村特別給付用単位_日数(div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue());
            builder.set市町村特別給付用支給限度基準額(div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue());
            builder.set履歴番号(最大履歴番号 + 1);
            builder.set市町村特別給付用給付率引下有フラグ(false);
            builder.set登録年月日(FlexibleDate.getNowDate());
            builder.set変更年月日(FlexibleDate.getNowDate());
            builder.set論理削除フラグ(false);
            manager.save市町村特別給付サービス内容(builder.build());
        } else if (!CommonButtonHolder.isDisplayNone(修正やめる)) {
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = manager.get市町村特別給付サービス内容(明細エリア初期値.getサービスコード(),
                    明細エリア初期値.get有効期間開始年月日(),
                    明細エリア初期値.get履歴番号());
            ShichosonTokubetuKyufuServiceBuilder builder = 市町村特別給付サービス内容.createBuilderForEdit();
            builder.set市町村特別給付用サービス名_正式名称(div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue());
            builder.set市町村特別給付用サービス名_略称(div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue());
            builder.set市町村特別給付用サービス有効期間終了年月日(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue().toFlexibleDate());
            builder.set市町村特別給付用単位_日数(div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue());
            builder.set市町村特別給付用支給限度基準額(div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue());
            builder.set変更年月日(FlexibleDate.getNowDate());
            manager.save市町村特別給付サービス内容(builder.build());
        } else if (!CommonButtonHolder.isDisplayNone(削除やめる)) {
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = manager.get市町村特別給付サービス内容(明細エリア初期値.getサービスコード(),
                    明細エリア初期値.get有効期間開始年月日(),
                    明細エリア初期値.get履歴番号());
            ShichosonTokubetuKyufuServiceBuilder builder = 市町村特別給付サービス内容.createBuilderForEdit();
            builder.set論理削除フラグ(true);
            builder.set変更年月日(FlexibleDate.getNowDate());
            manager.save市町村特別給付サービス内容(builder.build());
        }

    }

    /**
     * 項目が変更をチェックのメソッドです。
     *
     * @return Boolean
     */
    public boolean is項目が変更() {
        return !(div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().getValue().equals(明細エリア初期値.getサービスコード().substring(2))
                && div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue().equals(明細エリア初期値.get正式名称())
                && div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue().equals(明細エリア初期値.get略称())
                && div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue().equals(明細エリア初期値.get有効期間開始年月日().toRDate())
                && div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue().equals(明細エリア初期値.get有効期間終了年月日().toRDate())
                && div.getKubunShikyuGendogakuShosai().getRadKubun().getSelectedKey().equals(明細エリア初期値.getサービス区分())
                && div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue().equals(明細エリア初期値.get単位())
                && div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue().equals(明細エリア初期値.get支給限度基準額()));
    }

    /**
     * 選択行データ処理
     */
    public void 選択行データ処理() {
        dgServiceNaiyo_Row row = div.getDgServiceNaiyo().getClickedItem();
        ShichosonTokubetuKyufuServiceEntityResult entity = new ShichosonTokubetuKyufuServiceEntityResult();
        entity.setサービスコード(row.getServiceCode());
        entity.set有効期間開始年月日(new FlexibleDate(row.getServiceYukoKikanKaishiYMDSeireki().getValue().toString()));
        entity.set有効期間終了年月日(new FlexibleDate(row.getServiceYukoKikanShuryoYMDSeireki().getValue().toString()));
        entity.set正式名称(row.getServiceSeishikiName());
        if (単位.equals(row.getServiceKubun())) {
            entity.setサービス区分(単位コード);
        } else if (日数.equals(row.getServiceKubun())) {
            entity.setサービス区分(日数コード);
        }
        entity.set単位(new Decimal(row.getTanisuNissu().toString()));
        entity.set支給限度基準額(new Decimal(row.getShikyuGendogaku().toString()));
        entity.set略称(row.getServiceRyakushoName());
        entity.set履歴番号(Integer.parseInt(row.getRirekiNo().toString()));
        entity.set直近フラグ(row.getChokkinFlag());
        明細エリア初期値 = entity;
        initialize明細エリア(entity);
    }

    /**
     * 明細Entity内容を明細エリアに表示される。
     */
    private void initialize明細エリア(ShichosonTokubetuKyufuServiceEntityResult 明細Entity) {
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode1().setValue(サービスコード固定値);
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().setValue(明細Entity.getサービスコード().substring(2));
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().setValue(明細Entity.get正式名称());
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().setValue(明細Entity.get略称());
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().setValue(明細Entity.get有効期間開始年月日().toRDate());
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().setValue(明細Entity.get有効期間終了年月日().toRDate());
        div.getKubunShikyuGendogakuShosai().getRadKubun().setSelectedKey(明細Entity.getサービス区分());
        div.getKubunShikyuGendogakuShosai().getTxtTanni().setValue(明細Entity.get単位());
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().setValue(明細Entity.get支給限度基準額());
    }

}
