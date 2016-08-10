/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9010001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010001.ShinNendoKanriJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shinnendokanrijohosakusei.ShinNendoKanriJohoSakuseiManager;
import jp.co.ndensan.reams.db.dbb.service.core.shinnendokanrijohosakuseifinder.ShinNendoKanriJohoSakuseiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBB9010001_新年度管理情報作成のハンドラクラスです。
 *
 * @reamsid_L DBB-5721-010 chenyadong
 */
public class ShinNendoKanriJohoSakuseiHandler {

    private final ShinNendoKanriJohoSakuseiDiv div;
    private static final RString 処理枝番 = new RString("00");
    private static final RString 年度内連番 = new RString("00");

    /**
     * コンストラクタです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     */
    public ShinNendoKanriJohoSakuseiHandler(ShinNendoKanriJohoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        ShoriDateKanri 処理日付管理;
        FlexibleYear 年度 = new FlexibleYear(調定年度.toString());
        ShoriDateKanriManager manager = new ShoriDateKanriManager();

        処理日付管理 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課, ShoriName.新年度管理情報作成.get名称(), 年度.plusYear(1));
        if (処理日付管理 != null) {
            throw new ApplicationException(DbbErrorMessages.処理済み.getMessage());
        }
        div.getShinNendoKanriJohoSakuseiBatchParameter().getTxtTonendo().setValue(年度.wareki().toDateString());
        div.getTxtShiNendo().setValue(年度.plusYear(1).wareki().toDateString());
    }

    /**
     * 実行ボタン押下した時の処理のメソッドます。
     *
     */
    public void 実行ボタン押下した時の処理() {
        RString honNendo = new RDate(div.getShinNendoKanriJohoSakuseiBatchParameter().getTxtTonendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 本年度 = new FlexibleYear(honNendo);
        RString newNendo = new RDate(div.getTxtShiNendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 年度 = new FlexibleYear(newNendo);
        ShinNendoKanriJohoSakuseiManager imanager = InstanceProvider.create(ShinNendoKanriJohoSakuseiManager.class);
        List<ChohyoSeigyoHanyo> 新帳票制御汎用List = 帳票制御汎用の追加();
        ShoriDateKanri 処理日付管理 = 処理日付管理の追加();
        //TODO QA.1013
        List<Noki> 納期管理List = 納期管理の追加();
        imanager.追加(処理日付管理, 新帳票制御汎用List, 納期管理List);
    }

    /**
     * 処理日付管理の追加のメソッドます。
     *
     * @param 処理日付管理 ShoriDateKanri
     * @return 処理日付管理
     */
    private ShoriDateKanri 処理日付管理の追加() {
        RString newNendo = new RDate(div.getTxtShiNendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 年度 = new FlexibleYear(newNendo);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ShoriDateKanri 処理日付管理 = new ShoriDateKanri(SubGyomuCode.DBB介護賦課, 導入団体クラス.get地方公共団体コード(),
                ShoriName.新年度管理情報作成.get名称(), 処理枝番, 年度, 年度内連番);
        処理日付管理 = 処理日付管理.createBuilderForEdit()
                .set基準年月日(FlexibleDate.getNowDate())
                .set基準日時(YMDHMS.now()).build();
        return 処理日付管理;
    }

    /**
     * 納期管理の追加のメソッドます。
     *
     * @return 納期管理List
     */
    private List<Noki> 納期管理の追加() {
        RString newNendo = new RDate(div.getTxtShiNendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 年度 = new FlexibleYear(newNendo);
        RString honNendo = new RDate(div.getShinNendoKanriJohoSakuseiBatchParameter().getTxtTonendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 本年度 = new FlexibleYear(honNendo);
        HashMap<String, Object> param = createParameter(new RYear(本年度.toString()));
        ShinNendoKanriJohoSakuseiFinder finder = ShinNendoKanriJohoSakuseiFinder.createInstance();
        List<Noki> resultList = finder.getShinNendoKanriJohoSakusei(param);
        List<Noki> 納期管理List = new ArrayList();
        for (Noki items : resultList) {
            Noki item = items;
            if (item.get納期限().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
               item = item.createBuilderForEdit()
                        .set納期限(item.get納期限().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get納期限().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item = item.createBuilderForEdit()
                            .set納期限(item.get納期限().plusYear(1).plusDay(2)).build();
                } else {
                    item = item.createBuilderForEdit()
                            .set納期限(item.get納期限().plusYear(1)).build();
                }
            }

            if (item.get納期開始日().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
                item = item.createBuilderForEdit()
                        .set納期開始日(item.get納期開始日().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get納期開始日().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item = item.createBuilderForEdit()
                            .set納期開始日(item.get納期開始日().plusYear(1).plusDay(2)).build();
                } else {
                    item = item.createBuilderForEdit()
                            .set納期開始日(item.get納期開始日().plusYear(1)).build();
                }
            }

            if (item.get納期終了日().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
                item.createBuilderForEdit()
                        .set納期終了日(item.get納期終了日().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get納期終了日().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item.createBuilderForEdit()
                            .set納期終了日(item.get納期終了日().plusYear(1).plusDay(2)).build();
                } else {
                    item.createBuilderForEdit()
                            .set納期終了日(item.get納期終了日().plusYear(1)).build();
                }
            }

            if (item.get通知書発行日().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
                item = item.createBuilderForEdit()
                        .set通知書発行日(item.get通知書発行日().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get通知書発行日().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item = item.createBuilderForEdit()
                            .set通知書発行日(item.get通知書発行日().plusYear(1).plusDay(2)).build();
                } else {
                    item = item.createBuilderForEdit()
                            .set通知書発行日(item.get通知書発行日().plusYear(1)).build();
                }
            }

            if (item.get法定納期限().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
                item = item.createBuilderForEdit()
                        .set法定納期限(item.get法定納期限().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get法定納期限().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item = item.createBuilderForEdit()
                            .set法定納期限(item.get法定納期限().plusYear(1).plusDay(2)).build();
                } else {
                    item = item.createBuilderForEdit()
                            .set法定納期限(item.get法定納期限().plusYear(1)).build();
                }
            }

            if (item.get法定納期限等().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
                item = item.createBuilderForEdit()
                        .set法定納期限等(item.get法定納期限等().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get法定納期限等().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item = item.createBuilderForEdit()
                            .set法定納期限等(item.get法定納期限等().plusYear(1).plusDay(2)).build();
                } else {
                    item = item.createBuilderForEdit()
                            .set法定納期限等(item.get法定納期限等().plusYear(1)).build();
                }
            }

            if (item.get振替納期月().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
                item = item.createBuilderForEdit()
                        .set振替納期月(item.get振替納期月().plusYear(1).plusDay(1)).build();
            } else {
                if (item.get振替納期月().plusYear(1).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
                    item = item.createBuilderForEdit()
                            .set振替納期月(item.get振替納期月().plusYear(1).plusDay(2)).build();
                } else {
                    item = item.createBuilderForEdit()
                            .set振替納期月(item.get振替納期月().plusYear(1)).build();
                }
            }
           item = item.createBuilderForEdit()
                    .set調定年度(new RYear(年度.toString())).build();
            納期管理List.add(item);
        }
        return 納期管理List;
    }

    /**
     * 帳票制御汎用の追加のメソッドます。
     *
     * @param 帳票制御汎用manager ChohyoSeigyoHanyoManager
     * @return 帳票制御汎用List
     */
    private List<ChohyoSeigyoHanyo> 帳票制御汎用の追加() {
        ChohyoSeigyoHanyoManager 帳票制御汎用manager = new ChohyoSeigyoHanyoManager();
        RString newNendo = new RDate(div.getTxtShiNendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 年度 = new FlexibleYear(newNendo);
        RString honNendo = new RDate(div.getShinNendoKanriJohoSakuseiBatchParameter().getTxtTonendo().getValue().toString()).getYear().toDateString();
        FlexibleYear 本年度 = new FlexibleYear(honNendo);
        List<ChohyoSeigyoHanyo> 帳票制御汎用List = 帳票制御汎用manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課, 本年度);
        List<ChohyoSeigyoHanyo> 新帳票制御汎用List = new ArrayList();
        for (ChohyoSeigyoHanyo item : 帳票制御汎用List) {
            ChohyoSeigyoHanyo 帳票制御汎用 = new ChohyoSeigyoHanyo(item.getサブ業務コード(), item.get帳票分類ID(),
                    item.get項目名(), 年度);
            帳票制御汎用.createBuilderForEdit()
                    .set設定値(item.get設定値())
                    .set説明(item.get説明())
                    .set変更可否(item.is変更可否())
                    .setコードマスタサブ業務コード(item.getサブ業務コード())
                    .setコードマスタコード種別(item.getコードマスタコード種別()).build();
            新帳票制御汎用List.add(帳票制御汎用);
        }
        return 新帳票制御汎用List;
    }

    private HashMap<String, Object> createParameter(RYear 調定年度) {
        HashMap<String, Object> sqlParameter = new HashMap<>();
        sqlParameter.put("choteiNendo", 調定年度);
        return sqlParameter;
    }
}
