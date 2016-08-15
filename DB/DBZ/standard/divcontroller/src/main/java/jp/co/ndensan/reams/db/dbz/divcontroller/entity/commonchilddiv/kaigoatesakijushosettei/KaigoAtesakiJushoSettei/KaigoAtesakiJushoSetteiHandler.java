/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.service.core.kaigiatesakijushosettei.KaigoAtesakiJushoSetteiFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 介護宛先住所設定Handlerクラスです。
 *
 * @reamsid_L DBU-3990-030 wanghui
 */
public class KaigoAtesakiJushoSetteiHandler {

    private final KaigoAtesakiJushoSetteiDiv div;
    private final KaigoAtesakiJushoSetteiFinder finader;
    private final RString 都道府県 = new RString("都道府県");
    private final RString 郡 = new RString("郡");
    private final RString append郡 = new RString("＋郡");
    private final RString 市町村 = new RString("市町村");
    private final RString append市町村 = new RString("＋市町村");
    private final RString 方書 = new RString("方書");
    private final RString append方書 = new RString("＋方書");
    private final RString 住所 = new RString("＋住所＋番地");
    private final RString 番地 = new RString("住所＋番地");
    private final RString 行政区 = new RString("＋行政区＋番地");
    private final RString 行政区番地 = new RString("行政区＋番地");
    private final RString 住所番地 = new RString("＋住所＋番地、（行政区）");
    private final RString 住所行政区番地 = new RString("住所＋番地、（行政区）");
    private final RString 番地のみ = new RString("＋番地のみ");
    private final RString append番地のみ = new RString("番地のみ");
    private final RString 町域編集方法 = new RString("5");
    private final RString 町域編集方法_2 = new RString("2");
    private final RString 町域編集方法_3 = new RString("3");
    private final RString 町域編集方法_4 = new RString("4");
    private final RString 帳票独自 = JushoHenshuKubun.帳票独自.getコード();
    private final RString 市町村共通 = JushoHenshuKubun.市町村共通.getコード();

    /**
     * 介護宛先住所設定Handlerクラスです。
     *
     * @param div KaigoAtesakiJushoSetteiDiv
     */
    public KaigoAtesakiJushoSetteiHandler(KaigoAtesakiJushoSetteiDiv div) {
        this.div = div;
        finader = KaigoAtesakiJushoSetteiFinder.createInstance();
    }

    /**
     * 介護宛先住所設定の初期化です。
     *
     * @param サブ業務コード RString
     * @param 帳票分類ID RString
     */
    public void initialize(RString サブ業務コード, RString 帳票分類ID) {
        List<KeyValueDataSource> ddlShoriKubun = new ArrayList<>();
        for (JushoHenshuKubun code : JushoHenshuKubun.values()) {
            ddlShoriKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getRadJushoSettei().setDataSource(ddlShoriKubun);
        List<KaigoDonyuKeitai> 介護導入形態 = finader.select介護導入形態().records();
        for (KaigoDonyuKeitai donyu : 介護導入形態) {
            donyu.get導入形態コード();
            if (DonyuKeitaiCode.事務広域.getCode().equals(donyu.get導入形態コード().getCode())) {
                div.getRadJushoSettei().setDisabledItem(ddlShoriKubun);
            }
        }
        住所設定(サブ業務コード, 帳票分類ID);
        宛先住所編集書式();
        div.setHdnサブ業務コード(サブ業務コード);
        div.setHdn帳票分類ID(帳票分類ID);
    }

    public void initialize_systemKanri(boolean 住所設定使用可, boolean 宛先住所編集ボタン使用可,
            RString 都道府県名称表示有無, RString 郡名称表示有無, RString 市町村名称表示有無, RString 住所編集方法, RString 方書表示有無) {
        if (宛先住所編集ボタン使用可) {
            div.getRadJushoSettei().setSelectedKey(帳票独自);
        } else {
            div.getRadJushoSettei().setSelectedKey(市町村共通);
        }
        if (住所設定使用可) {
            div.getRadJushoSettei().setDisabled(false);
        } else {
            div.getRadJushoSettei().setDisabled(true);
        }
        div.setHdnChohyoDokujiTodofukenMei(都道府県名称表示有無);
        div.setHdnChohyoDokujiGunMei(郡名称表示有無);
        div.setHdnChohyoDokujiShichosonMei(市町村名称表示有無);
        div.setHdnChohyoDokujiHensyuHoho(住所編集方法);
        div.setHdnChohyoDokujiKatagaki(方書表示有無);
        宛先住所編集書式();
    }

    /**
     * 画面表示を制御する。
     *
     * @param サブ業務コード RString
     * @param 帳票分類ID RString
     */
    public void setradJushoSettei(RString サブ業務コード, RString 帳票分類ID) {
        if (帳票独自.equals(div.getRadJushoSettei().getSelectedKey())) {
            div.getBtnAtesakiJushoSettei().setDisabled(false);
            DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = finader.select帳票制御共通(サブ業務コード, 帳票分類ID);
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                RString 市町村共通_都道府県名表示有無 = 帳票独自;
                div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);
            } else {
                RString 市町村共通_都道府県名表示有無 = 市町村共通;
                div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);
            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                RString 帳票独自_郡名表示有無 = 帳票独自;
                div.setHdnChohyoDokujiGunMei(帳票独自_郡名表示有無);
            } else {
                RString 帳票独自_郡名表示有無 = 市町村共通;
                div.setHdnChohyoDokujiGunMei(帳票独自_郡名表示有無);
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                RString 帳票独自_市町村名表示有無 = 帳票独自;
                div.setHdnChohyoDokujiShichosonMei(帳票独自_市町村名表示有無);
            } else {
                RString 帳票独自_市町村名表示有無 = 市町村共通;
                div.setHdnChohyoDokujiShichosonMei(帳票独自_市町村名表示有無);
            }
            RString 帳票独自_町域編集方法 = 帳票制御共通.getJushoHenshuChoikiHenshuHoho();
            div.setHdnChohyoDokujiHensyuHoho(帳票独自_町域編集方法);
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                RString 帳票独自_方書表示有無 = 帳票独自;
                div.setHdnChohyoDokujiKatagaki(帳票独自_方書表示有無);
            } else {
                RString 帳票独自_方書表示有無 = 市町村共通;
                div.setHdnChohyoDokujiKatagaki(帳票独自_方書表示有無);
            }
        } else {
            div.getBtnAtesakiJushoSettei().setDisabled(true);
            RString 市町村共通_都道府県名表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_郡名表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_市町村名表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_町域編集方法 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_方書表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);
            div.setHdnChohyoDokujiGunMei(市町村共通_郡名表示有無);
            div.setHdnChohyoDokujiShichosonMei(市町村共通_市町村名表示有無);
            div.setHdnChohyoDokujiHensyuHoho(市町村共通_町域編集方法);
            div.setHdnChohyoDokujiKatagaki(市町村共通_方書表示有無);
        }
    }

    /**
     * is帳票独自フラグ。
     *
     * @return 帳票独自を選択している場合はTrueを返す。それ以外は、Falseを返す。
     */
    public boolean is帳票独自() {
        return 帳票独自.equals(div.getRadJushoSettei().getSelectedKey());
    }

    /**
     * is都道府県名表示フラグ。
     *
     * @return 帳票独自_都道府県名表示有無 を元にbooleanを返す。
     */
    public boolean is都道府県名表示() {
        return 帳票独自.equals(div.getHdnChohyoDokujiTodofukenMei());
    }

    /**
     * is郡名表示フラグ。
     *
     * @return .帳票独自_郡名表示有無 を元にbooleanを返す。
     */
    public boolean is郡名表示() {
        return 帳票独自.equals(div.getHdnChohyoDokujiGunMei());
    }

    /**
     * is市町村名表示フラグ。
     *
     * @return .帳票独自_市町村名表示有無 を元にbooleanを返す。
     */
    public boolean is市町村名表示() {
        return 帳票独自.equals(div.getHdnChohyoDokujiShichosonMei());
    }

    /**
     * get町域編集方法。
     *
     * @return 帳票独自_町域編集方法 を返す。
     */
    public RString get町域編集方法() {
        return div.getHdnChohyoDokujiHensyuHoho();
    }

    /**
     * is方書表示フラグ。
     *
     * @return 帳票独自_方書表示有無 を元にbooleanを返す。
     */
    public boolean is方書表示() {
        return 帳票独自.equals(div.getHdnChohyoDokujiKatagaki());
    }

    /**
     * 宛先住所編集ボタン。
     *
     */
    public void 宛先住所編集書式() {
        RStringBuilder 書式 = new RStringBuilder();
        if (帳票独自.equals(div.getHdnChohyoDokujiTodofukenMei())) {
            書式.append(都道府県);
        }
        if (帳票独自.equals(div.getHdnChohyoDokujiGunMei())) {
            if (!書式.toRString().isEmpty()) {
                書式.append(append郡);
            } else {
                書式.append(郡);
            }
        }
        if (帳票独自.equals(div.getHdnChohyoDokujiShichosonMei())) {
            if (!書式.toRString().isEmpty()) {
                書式.append(append市町村);
            } else {
                書式.append(市町村);
            }
        }
        if (帳票独自.equals(div.getHdnChohyoDokujiKatagaki())) {
            if (!書式.toRString().isEmpty()) {
                書式.append(append方書);
            } else {
                書式.append(方書);
            }
        }
        if (!町域編集方法.equals(div.getHdnChohyoDokujiHensyuHoho())) {
            if (帳票独自.equals(div.getHdnChohyoDokujiHensyuHoho())) {
                if (!書式.toRString().isEmpty()) {
                    書式.append(住所);
                } else {
                    書式.append(番地);
                }
            } else if (町域編集方法_2.equals(div.getHdnChohyoDokujiHensyuHoho())) {
                if (!書式.toRString().isEmpty()) {
                    書式.append(行政区);
                } else {
                    書式.append(行政区番地);
                }
            } else if (町域編集方法_3.equals(div.getHdnChohyoDokujiHensyuHoho())) {
                if (!書式.toRString().isEmpty()) {
                    書式.append(住所番地);
                } else {
                    書式.append(住所行政区番地);
                }
            } else if (町域編集方法_4.equals(div.getHdnChohyoDokujiHensyuHoho())) {
                if (!書式.toRString().isEmpty()) {
                    書式.append(番地のみ);
                } else {
                    書式.append(append番地のみ);
                }
            }
        }
        div.getTxtAtesakiJushoSettei().setValue(書式.toRString());
    }

    private void 住所設定(RString サブ業務コード, RString 帳票分類ID) {
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = finader.select帳票制御共通(サブ業務コード, 帳票分類ID);
        if (帳票独自.equals(帳票制御共通.getJushoHenshuKubun())) {
            div.getRadJushoSettei().setSelectedKey(帳票独自);
        } else {
            div.getRadJushoSettei().setSelectedKey(市町村共通);
        }
        if (市町村共通.equals(div.getRadJushoSettei().getSelectedKey())) {
            RString 市町村共通_都道府県名表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_郡名表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_市町村名表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_町域編集方法 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            RString 市町村共通_方書表示有無 = DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);
            div.setHdnChohyoDokujiGunMei(市町村共通_郡名表示有無);
            div.setHdnChohyoDokujiShichosonMei(市町村共通_市町村名表示有無);
            div.setHdnChohyoDokujiHensyuHoho(市町村共通_町域編集方法);
            div.setHdnChohyoDokujiKatagaki(市町村共通_方書表示有無);
        } else {
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                RString 市町村共通_都道府県名表示有無 = 帳票独自;
                div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);
            } else {
                RString 市町村共通_都道府県名表示有無 = 市町村共通;
                div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);
            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                RString 帳票独自_郡名表示有無 = 帳票独自;
                div.setHdnChohyoDokujiGunMei(帳票独自_郡名表示有無);
            } else {
                RString 帳票独自_郡名表示有無 = 市町村共通;
                div.setHdnChohyoDokujiGunMei(帳票独自_郡名表示有無);
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                RString 帳票独自_市町村名表示有無 = 帳票独自;
                div.setHdnChohyoDokujiShichosonMei(帳票独自_市町村名表示有無);
            } else {
                RString 帳票独自_市町村名表示有無 = 市町村共通;
                div.setHdnChohyoDokujiShichosonMei(帳票独自_市町村名表示有無);
            }
            RString 帳票独自_町域編集方法 = 帳票制御共通.getJushoHenshuChoikiHenshuHoho();
            div.setHdnChohyoDokujiHensyuHoho(帳票独自_町域編集方法);
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                RString 帳票独自_方書表示有無 = 帳票独自;
                div.setHdnChohyoDokujiKatagaki(帳票独自_方書表示有無);
            } else {
                RString 帳票独自_方書表示有無 = 市町村共通;
                div.setHdnChohyoDokujiKatagaki(帳票独自_方書表示有無);
            }
        }
    }
}
