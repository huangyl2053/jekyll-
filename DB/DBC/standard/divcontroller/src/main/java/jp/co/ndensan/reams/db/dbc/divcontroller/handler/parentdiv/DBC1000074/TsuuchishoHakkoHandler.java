/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000074;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyokettei.DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ChushutsuKikan;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.Insho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000074.TsuuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 基準収入額決定通知書発行のHandlerです。
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public class TsuuchishoHakkoHandler {

    private final TsuuchishoHakkoDiv div;
    private static final RString 入力チェック_申請 = new RString("申請");
    private static final RString 入力チェック_決定 = new RString("決定");
    private static final RString 入力チェック = new RString("入力チェック");
    private static final RString 処理名 = new RString("基準収入額適用決定通知書");
    private static final RString 出力順を = new RString("出力順を");
    private static final ReportId 帳票ID = new ReportId("DBC100074_KijunShunyugakuTekiyoKetteiTsuchisho");
    private static final int NUM_1 = 1;
    private final RDate システム日付 = RDate.getNowDate();

    /**
     *
     * @param div TsuuchishoHakkoDiv
     *
     */
    public TsuuchishoHakkoHandler(TsuuchishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * initializeのメソッドます。
     *
     */
    public void initialize() {

        set前排他();
        div.getRadChushutsukikan().setDataSource(get通知書発行_抽出期間());
        div.getDdlInsho().setDataSource(get通知書発行_印書());

        div.getRadChushutsukikan().setSelectedKey(ChushutsuKikan.申請年月日.getコード());
        div.getDdlInsho().setSelectedKey(Insho.発行済みも含める.getコード());

        div.getTxtSakuseiYMD().setValue(FlexibleDate.getNowDate());
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);

    }

    /**
     * set文書番号のメソッドます。
     *
     */
    public void set文書番号() {
        div.getCcdBunshoBangoInput().initialize(帳票ID, FlexibleDate.getNowDate());
    }

    /**
     * 申請年月日or決定年月日を初期化と、表示制御処理のメソッドます。
     *
     */
    public void set制御処理() {
        Association 市町村コードTemp = AssociationFinderFactory.createInstance().getAssociation();
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri 処理日付管理マスタ = manager.get処理日付管理マスタ(SubGyomuCode.DBC介護給付, 市町村コードTemp.get地方公共団体コード(),
                処理名, div.getRadChushutsukikan().getSelectedKey());
        RDate 前回対象開始日時Temp = null;
        RDate 前回対象終了日時Temp = null;
        if (処理日付管理マスタ != null) {
            if (処理日付管理マスタ.get対象開始日時() != null) {
                前回対象開始日時Temp = 処理日付管理マスタ.get対象開始日時().getDate();
            }
            if (処理日付管理マスタ.get対象終了日時() != null) {
                前回対象終了日時Temp = 処理日付管理マスタ.get対象終了日時().getDate();
            }
        }
        div.getTxtZenkaiTaishoYMD().setFromValue(前回対象開始日時Temp);
        div.getTxtZenkaiTaishoYMD().setToValue(前回対象終了日時Temp);
        if (ChushutsuKikan.申請年月日.getコード().equals(div.getRadChushutsukikan().getSelectedKey())) {
            div.getShinseiKetteiYMD().getTxtShinseiYMD().setDisabled(false);
            div.getShinseiKetteiYMD().getTxtKetteiYMD().setDisabled(true);
            if (前回対象終了日時Temp != null) {
                div.getShinseiKetteiYMD().getTxtShinseiYMD().setFromValue(前回対象終了日時Temp.plusDay(NUM_1));
            } else {
                div.getShinseiKetteiYMD().getTxtShinseiYMD().setFromValue(null);
            }
            div.getShinseiKetteiYMD().getTxtShinseiYMD().setToValue(システム日付);
        } else {
            div.getShinseiKetteiYMD().getTxtShinseiYMD().setDisabled(true);
            div.getShinseiKetteiYMD().getTxtKetteiYMD().setDisabled(false);
            if (前回対象終了日時Temp != null) {
                div.getShinseiKetteiYMD().getTxtKetteiYMD().setFromValue(前回対象終了日時Temp.plusDay(NUM_1));
            } else {
                div.getShinseiKetteiYMD().getTxtKetteiYMD().setFromValue(null);
            }
            div.getShinseiKetteiYMD().getTxtKetteiYMD().setToValue(システム日付);
        }
    }

    /**
     * 前排他のンメソッドです。
     *
     */
    public void set前排他() {
        LockingKey 前排他キー = new LockingKey(ResponseHolder.getMenuID());
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
    }

    /**
     * 前排他のreleaseです。
     *
     */
    public void release前排他() {
        LockingKey 前排他キー = new LockingKey(ResponseHolder.getMenuID());
        RealInitialLocker.release(前排他キー);
    }

    /**
     * 出力順の入力チェックです。
     *
     */
    public void set出力順の入力チェック() {
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace((出力順を).toString()).evaluate());
        }
    }

    /**
     * 申請年月日or決定年月日の入力チェックです。
     *
     * @return RString
     */
    public RString set入力チェック() {
        if (ChushutsuKikan.申請年月日.getコード().equals(div.getRadChushutsukikan().getSelectedKey())) {
            RDate 申請年月日_開始日 = div.getTxtShinseiYMD().getFromValue();
            RDate 申請年月日_終了日 = div.getTxtShinseiYMD().getToValue();
            if (申請年月日_開始日 != null && 申請年月日_終了日 != null) {
                return 入力チェック_申請;
            }
        } else {
            RDate 決定年月日_開始日 = div.getTxtKetteiYMD().getFromValue();
            RDate 決定年月日_終了日 = div.getTxtKetteiYMD().getToValue();
            if (決定年月日_開始日 != null && 決定年月日_終了日 != null) {
                return 入力チェック_決定;
            }
        }
        return 入力チェック;
    }

    private List<KeyValueDataSource> get通知書発行_抽出期間() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ChushutsuKikan 通知書発行_抽出期間 : ChushutsuKikan.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(通知書発行_抽出期間.getコード(), 通知書発行_抽出期間.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get通知書発行_印書() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (Insho 通知書発行_印書 : Insho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(通知書発行_印書.getコード(), 通知書発行_印書.get名称());
            dataSourceList.add(dataSource);
        }
        Collections.sort(dataSourceList, new Comparator<KeyValueDataSource>() {
            @Override
            public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
                RString key1 = o1.getKey();
                RString key2 = o2.getKey();
                int flag = 0;
                if (key1 != null && key2 != null) {
                    flag = key2.compareTo(key1);
                    if (0 == flag) {
                        flag = o2.getKey().compareTo(o1.getKey());
                    }
                }
                return flag;
            }
        });
        return dataSourceList;

    }

    /**
     * バッチパラメータ
     *
     * @param div TsuuchishoHakkoDiv
     * @return DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter
     */
    public DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter setBatchParameter(TsuuchishoHakkoDiv div) {
        DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter parameter = new DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter();
        parameter.set抽出期間(div.getRadChushutsukikan().getSelectedKey());
        parameter.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        parameter.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        FlexibleDate 開始日;
        FlexibleDate 終了日;
        if (ChushutsuKikan.申請年月日.getコード().equals(div.getRadChushutsukikan().getSelectedKey())) {
            RDate 開始日Rdate = div.getShinseiKetteiYMD().getTxtShinseiYMD().getFromValue();
            開始日 = 開始日Rdate == null ? FlexibleDate.MIN : new FlexibleDate(開始日Rdate.toString());
            RDate 終了日Rdate = div.getShinseiKetteiYMD().getTxtShinseiYMD().getToValue();
            終了日 = 終了日Rdate == null ? FlexibleDate.MAX : new FlexibleDate(終了日Rdate.toString());
        } else {
            RDate 開始日Rdate = div.getShinseiKetteiYMD().getTxtKetteiYMD().getFromValue();
            開始日 = 開始日Rdate == null ? FlexibleDate.MIN : new FlexibleDate(開始日Rdate.toString());
            RDate 終了日Rdate = div.getShinseiKetteiYMD().getTxtKetteiYMD().getToValue();
            終了日 = 終了日Rdate == null ? FlexibleDate.MAX : new FlexibleDate(終了日Rdate.toString());
        }
        parameter.set開始日(開始日);
        parameter.set終了日(終了日);
        parameter.set印書(div.getDdlInsho().getSelectedKey());
        parameter.set作成日(div.getTxtSakuseiYMD().getValue());
        parameter.set文書番号(div.getCcdBunshoBangoInput().get文書番号());
        parameter.set帳票出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID()));

        return parameter;
    }
}
