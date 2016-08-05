/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.saihakkofinder.SaiHakko;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.KoikiZenShichosonJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140001.ShotokushokaihyoIkkatuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140001.dgSaihakko_Row;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.saihakkofinder.SaiHakkoEntity;
import jp.co.ndensan.reams.db.dbb.service.core.saihakkofinder.SaiHakkoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.auth.AuthUser;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 画面設計_DBBGM51001_所得照会票一括発行
 *
 * @reamsid_L DBB-1720-010 lijunjun
 */
public class ShotokushokaihyoIkkatuHandler {

    private static final RString キー_KEY0 = new RString("key0");
    private static final RString キー_KEY1 = new RString("key1");
    private static final RString INDEX_0 = new RString("0");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final RString INDEX_3 = new RString("3");
    private static final RString INDEX_111 = new RString("111");
    private static final ReportId 帳票ID = new ReportId("DBB200024_ShotokushokaihyoHakkoIchiran");
    private final ShotokushokaihyoIkkatuDiv div;

    /**
     * コンストラクタです
     *
     * @param div ShotokushokaihyoIkkatuDiv
     */
    public ShotokushokaihyoIkkatuHandler(ShotokushokaihyoIkkatuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ShotokushokaihyoIkkatuHandler
     */
    public static ShotokushokaihyoIkkatuHandler of(ShotokushokaihyoIkkatuDiv div) {
        return new ShotokushokaihyoIkkatuHandler(div);
    }

    /**
     * 初期化のメソッド
     */
    public void initialize() {
        set処理年度();
        div.getDdlShoriNendo().setSelectedIndex(0);
        RString 照会年月日 = new FlexibleDate(RDate.getNowDate().toString()).wareki().toDateString();
        div.getTxtShokaiYMD().setValue(new RDate(照会年月日.toString()));
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 帳票ID);
        set再発行対象();
    }

    /**
     * 再発行対象をonLoadイベント。
     */
    public void set再発行対象() {
        List<dgSaihakko_Row> rowList = new ArrayList<>();
        RDate 処理年度 = new RDate(div.getDdlShoriNendo().getSelectedValue().toString());
        List<SaiHakko> 再発行対象 = SaiHakkoFinder.createInstance().getSaiHakko(処理年度.getYear());
        if (再発行対象 != null && !再発行対象.isEmpty()) {
            for (SaiHakko saiHakko : 再発行対象) {
                dgSaihakko_Row row = new dgSaihakko_Row();
                row.setTxtShoriNendo(saiHakko.getEntity().get処理年度().wareki().toDateString());
                row.setTxtShoriNichiji(new FlexibleDate(saiHakko.getEntity().get処理日時()
                        .getRDateTime().getDate().toDateString()).wareki().toDateString());
                row.setTxtHakkoKensu(new RString(String.valueOf(saiHakko.getEntity().get発行件数())));
                RString 氏名 = new RString(AuthUser.getUser(saiHakko.getEntity().getユーザ()).getKanaShimei().toString());
                RString ユーザ = saiHakko.getEntity().getユーザ().concat(RString.FULL_SPACE).concat(氏名);
                row.setTxtUser(ユーザ);
                rowList.add(row);
            }
        }
        div.getDgSaihakko().setDataSource(rowList);
    }

    /**
     * 処理年度の初期化
     */
    public void set処理年度() {
        RYear 処理年度_当初年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_当初年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        RYear 処理年度_所得年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        List<KeyValueDataSource> 処理年度 = new ArrayList<>();
        int flag = 0;
        for (int i = 処理年度_当初年度.getYearValue(); i <= 処理年度_所得年度.getYearValue(); i++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(String.valueOf(flag)));
            dataSource.setValue(new RYear(String.valueOf(i)).wareki().toDateString());
            処理年度.add(dataSource);
            flag++;
        }
        div.getDdlShoriNendo().setDataSource(処理年度);
    }

    /**
     * 再発行一覧の初期化
     *
     * @param row dgSaihakko_Row
     */
    public void set再発行一覧(dgSaihakko_Row row) {
        RYear 処理年度 = new RYear(div.getDdlShoriNendo().getSelectedValue().toString());
        List<SaiHakko> 再発行対象リスト = SaiHakkoFinder.createInstance().getSaiHakko(処理年度);
        if (再発行対象リスト != null && !再発行対象リスト.isEmpty()) {
            for (SaiHakko saiHakko : 再発行対象リスト) {
                SaiHakkoEntity 再発行対象Entity = saiHakko.getEntity();
                row.setTxtShoriNendo(new RString(再発行対象Entity.get処理年度().toString()));
                row.setTxtShoriNichiji(new RString(再発行対象Entity.get処理日時().toString()));
                row.setTxtHakkoKensu(new RString(String.valueOf(再発行対象Entity.get発行件数())));
                row.setTxtUser(再発行対象Entity.getユーザ());
            }
        }
    }

    /**
     * パラメタを取得します。
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @param テストプリント boolean
     * @param 再発行する boolean
     * @return ShotokuShokaihyoHakkoBatchParameter
     */
    public ShotokuShokaihyoHakkoBatchParameter getParameter(ShotokushokaihyoIkkatuDiv div, boolean テストプリント,
            boolean 再発行する) {
        ShotokuShokaihyoHakkoBatchParameter parameter = new ShotokuShokaihyoHakkoBatchParameter();
        RYear 処理年度 = new RYear(div.getDdlShoriNendo().getSelectedValue().toString());
        parameter.set処理年度(new FlexibleYear(new RString(処理年度.toString())));
        RDate 照会日 = div.getTxtShokaiYMD().getValue();
        parameter.set照会年月日(new FlexibleDate(new RString(照会日.toString())));
        RString 出力対象 = RString.EMPTY;
        List<RString> selectedKeys = div.getChkShuturyokuTaisho().getSelectedKeys();
        if (!selectedKeys.contains(キー_KEY0) && !selectedKeys.contains(キー_KEY1)) {
            出力対象 = INDEX_0;
        } else if (selectedKeys.contains(キー_KEY0) && selectedKeys.contains(キー_KEY1)) {
            出力対象 = INDEX_1;
        } else if (selectedKeys.contains(キー_KEY0) && !selectedKeys.contains(キー_KEY1)) {
            出力対象 = INDEX_2;
        } else if (selectedKeys.contains(キー_KEY0) && !selectedKeys.contains(キー_KEY1)) {
            出力対象 = INDEX_3;
        }
        parameter.set出力対象(出力対象);
        Long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
        parameter.set出力順ID(出力順ID);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        parameter.set導入形態コード(導入形態コード);
        if (テストプリント) {
            parameter.setテストプリント(true);
        } else {
            parameter.setテストプリント(false);
        }
        List<SaiHakkoParameter> 再発行対象リスト = new ArrayList<>();
        if (再発行する) {
            List<dgSaihakko_Row> selectedItems = div.getDgSaihakko().getSelectedItems();
            for (dgSaihakko_Row row : selectedItems) {
                SaiHakkoParameter 再発行param = new SaiHakkoParameter();
                再発行param.setユーザ(row.getTxtUser());
                再発行param.set処理年度(new RYear(new RString(row.getTxtShoriNendo().toString())));
                再発行param.set処理日時(new YMDHMS(new RString(row.getTxtShoriNichiji().toString())));
                再発行param.set発行件数(Integer.valueOf(row.getTxtHakkoKensu().toString()));
                再発行対象リスト.add(再発行param);
            }
        }
        parameter.set再発行対象リスト(再発行対象リスト);
        if (INDEX_111.equals(導入形態コード)) {
            SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJoho = KoikiShichosonJohoFinder.createInstance().getZenShichosonJoho();
            List<KoikiZenShichosonJoho> koikiZenShichosonJohoList = koikiZenShichosonJoho.records();
            List<KoikiZenShichosonJohoParameter> 構成市町村情報リスト = get構成市町村情報リスト(koikiZenShichosonJohoList);
            parameter.set構成市町村情報リスト(構成市町村情報リスト);
        }
        return parameter;
    }

    private List<KoikiZenShichosonJohoParameter> get構成市町村情報リスト(List<KoikiZenShichosonJoho> koikiZenShichosonJohoList) {
        List<KoikiZenShichosonJohoParameter> 構成市町村情報リスト = new ArrayList<>();
        for (KoikiZenShichosonJoho joho : koikiZenShichosonJohoList) {
            KoikiZenShichosonJohoParameter 構成市町村情報param = new KoikiZenShichosonJohoParameter();
            構成市町村情報param.setShichosonShokibetsuID(joho.get市町村識別ID());
            構成市町村情報param.setShichosonCode(joho.get市町村コード());
            構成市町村情報param.setShoKisaiHokenshaNo(joho.get証記載保険者番号());
            構成市町村情報param.setKokuhorenKoikiShichosonNo(joho.get国保連広域内市町村番号());
            構成市町村情報param.setShichosonMeisho(joho.get市町村名称());
            構成市町村情報param.setTodofukenMeisho(joho.get都道府県名称());
            構成市町村情報param.setGunMeisho(joho.get郡名称());
            構成市町村情報param.setYubinNo(joho.get郵便番号());
            構成市町村情報param.setJusho(joho.get住所());
            構成市町村情報param.setTelNo(joho.get電話番号());
            構成市町村情報param.setYusenChikuCode(joho.get最優先地区コード());
            構成市町村情報param.setTyohyoTodoufukenHyojiUmu(joho.get帳票用都道府県名称表示有無());
            構成市町村情報param.setTyohyoGunHyojiUmu(joho.get帳票用郡名称表示有無());
            構成市町村情報param.setTyohyoShichosonHyojiUmu(joho.get帳票用市町村名称表示有無());
            構成市町村情報param.setTyohyoJushoHenshuHouhou(joho.get帳票用住所編集方法());
            構成市町村情報param.setTyohyoKatagakiHyojiUmu(joho.get帳票用方書表示有無());
            構成市町村情報param.setRojinhokenShichosonNo(joho.get老人保健市町村番号());
            構成市町村情報param.setRokenJukyushaNoTaikei(joho.get老人保健受給者番号体系());
            構成市町村情報param.setShotokuHikidashiHoho(joho.get所得引出方法());
            構成市町村情報param.setTokuchoBunpaishuyaku(joho.get特徴分配集約());
            構成市町村情報param.setIkoYMD(joho.get移行日());
            構成市町村情報param.setKanyuYMD(joho.get加入日());
            構成市町村情報param.setRidatsuYMD(joho.get離脱日());
            構成市町村情報param.setGappeiKyuShichosonKubun(joho.get合併旧市町村区分());
            構成市町村情報param.setGappeiKyuShichosonHyojiUmu(joho.get合併旧市町村表示有無());
            構成市町村情報param.setGappeiChiikiNo(joho.get合併情報地域番号());
            構成市町村情報param.setUnyoHokenshaNo(joho.get運用保険者番号());
            構成市町村情報param.setUnyoKaishiYMD(joho.get運用開始日());
            構成市町村情報param.setUnyoShuryoYMD(joho.get運用終了日());
            構成市町村情報param.setUnyoKeitaiKubun(joho.get運用形態区分());
            構成市町村情報リスト.add(構成市町村情報param);
        }
        return 構成市町村情報リスト;
    }

    /**
     * 再発行対象のチェック
     *
     * @param 再発行する boolean
     * @return boolean
     */
    public boolean is再発行対象のチェック(boolean 再発行する) {
        List<dgSaihakko_Row> selectedItems = div.getDgSaihakko().getSelectedItems();
        return 再発行する && (selectedItems == null || selectedItems.isEmpty());
    }

    /**
     * テストプリントを取得します。
     *
     * @return boolean
     */
    public boolean getテストプリント() {
        return div.getChkTestPrint().isAllSelected();
    }

    /**
     * 再発行するを取得します。
     *
     * @return boolean
     */
    public boolean get再発行する() {
        return div.getChkSaihakko().isAllSelected();
    }

}
