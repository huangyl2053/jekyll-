/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010001.ShinNendoKanriJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shinnendokanrijohosakusei.ShinNendoKanriJohoSakuseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
            //throw new ApplicationException(new ErrorMessage("","この機能は処理済みです。"));
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

        ShinNendoKanriJohoSakuseiManager imanager = InstanceProvider.create(ShinNendoKanriJohoSakuseiManager.class);
        List<ChohyoSeigyoHanyo> 新帳票制御汎用List = 帳票制御汎用の追加();
        ShoriDateKanri 処理日付管理 = 処理日付管理の追加();
        //TODO QA.1013
        imanager.追加(処理日付管理, 新帳票制御汎用List);
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
        処理日付管理.createBuilderForEdit()
                .set基準年月日(FlexibleDate.getNowDate())
                .set基準日時(YMDHMS.now()).build();
        return 処理日付管理;
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
        List<ChohyoSeigyoHanyo> 帳票制御汎用List = 帳票制御汎用manager.get帳票制御汎用(本年度);
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
}
