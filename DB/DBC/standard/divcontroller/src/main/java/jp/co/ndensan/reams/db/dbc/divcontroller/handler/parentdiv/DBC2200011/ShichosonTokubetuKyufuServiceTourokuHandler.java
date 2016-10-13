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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final RString 削除やめる = new RString("btnSaikujoCancel");
    private static final RString 追加やめる = new RString("btnTsuikaCancel");
    private static final RString 修正やめる = new RString("btnShuseiCancel");
    private static final RString 保存する = new RString("btnUpdate");
    private static final RString 直近フラグ = new RString("1");

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
            initializeGrid(市町村特別給付サービス内容一覧情報);
            ShichosonTokubetuKyufuServiceEntityResult 明細Entity = 市町村特別給付サービス内容一覧情報.get(div.getDgServiceNaiyo().getActiveRowId());
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

        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().clearValue();
        div.getKubunShikyuGendogakuShosai().getRadKubun().setSelectedKey(単位コード);
        div.getKubunShikyuGendogakuShosai().getTxtTanni().clearValue();
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().clearValue();

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
        RString serviceCode = サービスコード固定値.concat(div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().getValue());
        FlexibleDate 有効期間開始年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue() != null
                ? new FlexibleDate(div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue().toDateString()) : FlexibleDate.EMPTY;
        int 履歴番号 = div.getKubunShikyuGendogakuShosai().getHdnRirekiNo().getValue().isNullOrEmpty()
                ? 0 : Integer.parseInt(div.getKubunShikyuGendogakuShosai().getHdnRirekiNo().getValue().toString());

        if (!CommonButtonHolder.isDisplayNone(追加やめる)) {
            dgServiceNaiyo_Row 直近データ = null;
            for (dgServiceNaiyo_Row row : div.getDgServiceNaiyo().getDataSource()) {
                if (row.getChokkinFlag().equals(直近フラグ)) {
                    直近データ = row;
                    break;
                }
            }
            Integer 最大履歴番号 = finder.get最大履歴番号(serviceCode);
            最大履歴番号 = 最大履歴番号 == null ? 0 : 最大履歴番号;
            ShichosonTokubetuKyufuService entity = new ShichosonTokubetuKyufuService(serviceCode,
                    有効期間開始年月日,
                    最大履歴番号.intValue() + 1);
            ShichosonTokubetuKyufuServiceBuilder builder = entity.createBuilderForEdit();
            builder.set市町村特別給付用サービスコード(serviceCode);
            builder.set市町村特別給付用サービス名_正式名称(div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue());
            builder.set市町村特別給付用サービス名_略称(div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue());
            builder.set市町村特別給付用サービス有効期間開始年月日(有効期間開始年月日);
            builder.set市町村特別給付用サービス有効期間終了年月日(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue() != null
                    ? new FlexibleDate(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue().toDateString()) : FlexibleDate.EMPTY);
            builder.set市町村特別給付用サービス区分(div.getKubunShikyuGendogakuShosai().getRadKubun().getSelectedKey());
            builder.set市町村特別給付用単位_日数(div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue());
            builder.set市町村特別給付用支給限度基準額(div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue());
            builder.set履歴番号(最大履歴番号 + 1);
            builder.set市町村特別給付用給付率引下有フラグ(false);
            builder.set登録年月日(FlexibleDate.getNowDate());
            builder.set変更年月日(FlexibleDate.getNowDate());
            builder.set論理削除フラグ(false);
            manager.save市町村特別給付サービス内容(builder.build());
            if (直近データ != null && 直近データ.getServiceYukoKikanShuryoYMD().isNullOrEmpty()) {
                ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = manager.get市町村特別給付サービス内容(直近データ.getServiceCode(),
                        new FlexibleDate(直近データ.getServiceYukoKikanKaishiYMDSeireki().getValue().toDateString()),
                        Integer.parseInt(直近データ.getRirekiNo().toString()));
                ShichosonTokubetuKyufuServiceBuilder updBuilder = 市町村特別給付サービス内容.createBuilderForEdit();
                updBuilder.set市町村特別給付用サービス有効期間終了年月日(有効期間開始年月日.minusDay(1));
                updBuilder.set変更年月日(FlexibleDate.getNowDate());
                manager.save市町村特別給付サービス内容(updBuilder.build());
            }
        } else if (!CommonButtonHolder.isDisplayNone(修正やめる)) {
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = manager.get市町村特別給付サービス内容(serviceCode,
                    有効期間開始年月日,
                    履歴番号);
            ShichosonTokubetuKyufuServiceBuilder builder = 市町村特別給付サービス内容.createBuilderForEdit();
            builder.set市町村特別給付用サービス名_正式名称(div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue());
            builder.set市町村特別給付用サービス名_略称(div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue());
            builder.set市町村特別給付用サービス有効期間終了年月日(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue() != null
                    ? new FlexibleDate(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue().toDateString()) : FlexibleDate.EMPTY);
            builder.set市町村特別給付用単位_日数(div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue());
            builder.set市町村特別給付用支給限度基準額(div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue());
            builder.set変更年月日(FlexibleDate.getNowDate());
            manager.save市町村特別給付サービス内容(builder.build());
        } else if (!CommonButtonHolder.isDisplayNone(削除やめる)) {
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = manager.get市町村特別給付サービス内容(serviceCode,
                    有効期間開始年月日,
                    履歴番号);
            ShichosonTokubetuKyufuServiceBuilder builder = 市町村特別給付サービス内容.createBuilderForEdit();
            builder.set論理削除フラグ(true);
            builder.set変更年月日(FlexibleDate.getNowDate());
            manager.save市町村特別給付サービス内容(builder.build());
        }
        LockingKey 排他キー = new LockingKey(serviceCode,
                有効期間開始年月日, 履歴番号);
        RealInitialLocker.release(排他キー);
        ShichosonTokubetuKyufuServiceFinder service = ShichosonTokubetuKyufuServiceFinder.createInstance();
        List<ShichosonTokubetuKyufuServiceEntityResult> 市町村特別給付サービス内容一覧情報 = service.get一覧情報();
        initializeGrid(市町村特別給付サービス内容一覧情報);
        initialize照会モード();
    }

    /**
     * 追加項目が変更をチェックのメソッドです。
     *
     * @return Boolean
     */
    public boolean is追加項目が変更() {
        RString serviceCode = div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().getValue();
        RDate 有効期間開始年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue();
        RDate 有効期間終了年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue();
        RString 正式名称 = div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue();
        RString 略称 = div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue();
        RString 区分 = div.getKubunShikyuGendogakuShosai().getRadKubun().getSelectedKey();
        Decimal 単位_日数 = div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue();
        Decimal 支給限度基準額 = div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue();

        return !(serviceCode.isNullOrEmpty() && 有効期間開始年月日 == null
                && 有効期間終了年月日 == null && 正式名称.isEmpty()
                && 略称.isEmpty() && 区分.equals(単位コード)
                && 単位_日数 == null && 支給限度基準額 == null);
    }

    /**
     * 修正項目が変更をチェックのメソッドです。
     *
     * @return Boolean
     */
    public boolean is修正項目が変更() {
        ShichosonTokubetuKyufuServiceManager manager = new ShichosonTokubetuKyufuServiceManager();

        RString serviceCode = サービスコード固定値.concat(div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().getValue());
        RDate 有効期間開始年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM().getValue();
        RDate 有効期間終了年月日 = div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM().getValue();
        RString 正式名称 = div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().getValue();
        RString 略称 = div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().getValue();
        RString 区分 = div.getKubunShikyuGendogakuShosai().getRadKubun().getSelectedKey();
        Decimal 単位_日数 = div.getKubunShikyuGendogakuShosai().getTxtTanni().getValue();
        Decimal 支給限度基準額 = div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().getValue();

        dgServiceNaiyo_Row row = div.getDgServiceNaiyo().getActiveRow();
        ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = manager.get市町村特別給付サービス内容(row.getServiceCode(),
                row.getServiceYukoKikanKaishiYMDSeireki().getValue().toFlexibleDate(),
                Integer.parseInt(row.getRirekiNo().toString()));

        return 市町村特別給付サービス内容.createBuilderForEdit()
                .set市町村特別給付用サービスコード(serviceCode)
                .set市町村特別給付用サービス名_正式名称(正式名称)
                .set市町村特別給付用サービス名_略称(略称)
                .set市町村特別給付用サービス有効期間開始年月日(有効期間開始年月日 != null ? new FlexibleDate(有効期間開始年月日.toDateString()) : FlexibleDate.EMPTY)
                .set市町村特別給付用サービス有効期間終了年月日(有効期間終了年月日 != null ? new FlexibleDate(有効期間終了年月日.toDateString()) : FlexibleDate.EMPTY)
                .set市町村特別給付用サービス区分(区分)
                .set市町村特別給付用単位_日数(単位_日数)
                .set市町村特別給付用支給限度基準額(支給限度基準額)
                .build().hasChanged();
    }

    /**
     * 選択行データ処理
     */
    public void 選択行データ処理() {
        dgServiceNaiyo_Row row = div.getDgServiceNaiyo().getClickedItem();
        ShichosonTokubetuKyufuServiceEntityResult entity = new ShichosonTokubetuKyufuServiceEntityResult();
        entity.setサービスコード(row.getServiceCode());
        entity.set有効期間開始年月日(row.getServiceYukoKikanKaishiYMDSeireki().getValue() != null
                ? new FlexibleDate(row.getServiceYukoKikanKaishiYMDSeireki().getValue().toString()) : FlexibleDate.EMPTY);
        entity.set有効期間終了年月日(row.getServiceYukoKikanShuryoYMDSeireki().getValue() != null
                ? new FlexibleDate(row.getServiceYukoKikanShuryoYMDSeireki().getValue().toString()) : FlexibleDate.EMPTY);
        entity.set正式名称(row.getServiceSeishikiName());
        if (単位.equals(row.getServiceKubun())) {
            entity.setサービス区分(単位コード);
        } else if (日数.equals(row.getServiceKubun())) {
            entity.setサービス区分(日数コード);
        }
        entity.set単位(row.getTanisuNissu().getValue());
        entity.set支給限度基準額(row.getShikyuGendogaku().getValue());
        entity.set略称(row.getServiceRyakushoName());
        entity.set履歴番号(Integer.parseInt(row.getRirekiNo().toString()));
        entity.set直近フラグ(row.getChokkinFlag());
        initialize明細エリア(entity);
    }

    /**
     * 入力された値を破棄します
     */
    public void discard入力内容() {
        dgServiceNaiyo_Row row = div.getDgServiceNaiyo().getActiveRow();
        if (row == null) {
            row = div.getDgServiceNaiyo().getDataSource().get(0);
        }
        ShichosonTokubetuKyufuServiceEntityResult entity = new ShichosonTokubetuKyufuServiceEntityResult();
        entity.setサービスコード(row.getServiceCode());
        entity.set有効期間開始年月日(row.getServiceYukoKikanKaishiYMDSeireki().getValue() != null
                ? new FlexibleDate(row.getServiceYukoKikanKaishiYMDSeireki().getValue().toString()) : FlexibleDate.EMPTY);
        entity.set有効期間終了年月日(row.getServiceYukoKikanShuryoYMDSeireki().getValue() != null
                ? new FlexibleDate(row.getServiceYukoKikanShuryoYMDSeireki().getValue().toString()) : FlexibleDate.EMPTY);
        entity.set正式名称(row.getServiceSeishikiName());
        if (単位.equals(row.getServiceKubun())) {
            entity.setサービス区分(単位コード);
        } else if (日数.equals(row.getServiceKubun())) {
            entity.setサービス区分(日数コード);
        }
        entity.set単位(row.getTanisuNissu().getValue());
        entity.set支給限度基準額(row.getShikyuGendogaku().getValue());
        entity.set略称(row.getServiceRyakushoName());
        entity.set履歴番号(Integer.parseInt(row.getRirekiNo().toString()));
        entity.set直近フラグ(row.getChokkinFlag());
        initialize明細エリア(entity);
        initialize照会モード();
    }

    /**
     * 明細Entity内容を明細エリアに表示される。
     */
    private void initialize明細エリア(ShichosonTokubetuKyufuServiceEntityResult 明細Entity) {
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode1().setValue(サービスコード固定値);
        div.getKubunShikyuGendogakuShosai().getTxtServiceCode2().setValue(明細Entity.getサービスコード().substring(2));
        div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho().setValue(明細Entity.get正式名称());
        div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho().setValue(明細Entity.get略称());
        div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM()
                .setValue(明細Entity.get有効期間開始年月日() != null && !明細Entity.get有効期間開始年月日().isEmpty()
                        ? new RDate(明細Entity.get有効期間開始年月日().toString()) : null);
        div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM()
                .setValue(明細Entity.get有効期間終了年月日() != null && !明細Entity.get有効期間終了年月日().isEmpty()
                        ? new RDate(明細Entity.get有効期間終了年月日().toString()) : null);
        div.getKubunShikyuGendogakuShosai().getRadKubun().setSelectedKey(明細Entity.getサービス区分());
        div.getKubunShikyuGendogakuShosai().getTxtTanni().setValue(明細Entity.get単位());
        div.getKubunShikyuGendogakuShosai().getTxtShikyuGendogaku().setValue(明細Entity.get支給限度基準額());
        div.getKubunShikyuGendogakuShosai().getHdnRirekiNo().setValue(new RString(明細Entity.get履歴番号()));
    }

    private void initializeGrid(List<ShichosonTokubetuKyufuServiceEntityResult> 市町村特別給付サービス内容一覧情報) {
        List<dgServiceNaiyo_Row> dataSource = new ArrayList<>();
        for (ShichosonTokubetuKyufuServiceEntityResult entity : 市町村特別給付サービス内容一覧情報) {
            dgServiceNaiyo_Row row = new dgServiceNaiyo_Row();
            row.setServiceCode(entity.getサービスコード());
            row.setServiceYukoKikanKaishiYMD(entity.get有効期間開始年月日() != null && !entity.get有効期間開始年月日().isEmpty()
                    ? entity.get有効期間開始年月日().wareki().toDateString() : RString.EMPTY);
            row.setServiceYukoKikanShuryoYMD(entity.get有効期間終了年月日() != null && !entity.get有効期間終了年月日().isEmpty()
                    ? entity.get有効期間終了年月日().wareki().toDateString() : RString.EMPTY);
            row.setServiceSeishikiName(entity.get正式名称());
            if (単位コード.equals(entity.getサービス区分())) {
                row.setServiceKubun(単位);
            } else if (日数コード.equals(entity.getサービス区分())) {
                row.setServiceKubun(日数);
            }
            row.getTanisuNissu().setValue(entity.get単位());
            row.getShikyuGendogaku().setValue(entity.get支給限度基準額());
            row.setServiceRyakushoName(entity.get略称());
            row.setRirekiNo(new RString(entity.get履歴番号()));
            row.setChokkinFlag(entity.get直近フラグ());
            row.getServiceYukoKikanKaishiYMDSeireki().setValue(entity.get有効期間開始年月日() != null && !entity.get有効期間開始年月日().isEmpty()
                    ? new RDate(entity.get有効期間開始年月日().toString()) : null);
            row.getServiceYukoKikanShuryoYMDSeireki().setValue(entity.get有効期間終了年月日() != null && !entity.get有効期間終了年月日().isEmpty()
                    ? new RDate(entity.get有効期間終了年月日().toString()) : null);
            dataSource.add(row);
        }
        div.getDgServiceNaiyo().setDataSource(dataSource);
        if (div.getDgServiceNaiyo().getActiveRow() == null) {
            div.getDgServiceNaiyo().setActiveRowId(0);
        }
    }
}
