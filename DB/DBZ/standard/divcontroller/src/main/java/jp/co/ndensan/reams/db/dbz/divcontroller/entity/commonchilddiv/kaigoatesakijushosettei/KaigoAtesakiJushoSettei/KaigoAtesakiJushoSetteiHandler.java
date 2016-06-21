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
import jp.co.ndensan.reams.db.dbz.service.core.basic.kaigiatesakijushosettei.KaigoAtesakiJushoSetteiFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 介護宛先住所設定Handlerクラスです。
 *
 * @reamsid_L　DBU-3990-030　wanghui
 */
public class KaigoAtesakiJushoSetteiHandler {

    private final KaigoAtesakiJushoSetteiDiv div;
    private final KaigoAtesakiJushoSetteiFinder finader;
    private final RString 帳票独自 = new RString("1");

    public KaigoAtesakiJushoSetteiHandler(KaigoAtesakiJushoSetteiDiv div) {
        this.div = div;
        finader = KaigoAtesakiJushoSetteiFinder.createInstance();
    }

    public void initialize(RString サブ業務コード, RString 帳票分類ID) {
        List<KeyValueDataSource> ddlShoriKubun = new ArrayList<>();
        ddlShoriKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
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
        if (帳票独自.equals(div.getRadJushoSettei().getSelectedKey())) {
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
            div.setHdnShichosonKyotsuTodofukenMei(市町村共通_都道府県名表示有無);
            div.setHdnShichosonKyotsuGunMei(市町村共通_郡名表示有無);
            div.setHdnShichosonKyotsuShichosonMei(市町村共通_市町村名表示有無);
            div.setHdnShichosonKyotsuHensyuHoho(市町村共通_町域編集方法);
            div.setHdnShichosonKyotsuKatagaki(市町村共通_方書表示有無);
        } else {
            DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = finader.select帳票制御共通(サブ業務コード, 帳票分類ID);
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                RString 市町村共通_都道府県名表示有無 = new RString("1");
                div.setHdnChohyoDokujiTodofukenMei(市町村共通_都道府県名表示有無);

            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                RString 帳票独自_郡名表示有無 = new RString("1");
                div.setHdnChohyoDokujiGunMei(帳票独自_郡名表示有無);
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                RString 帳票独自_市町村名表示有無 = new RString("1");
                div.setHdnChohyoDokujiShichosonMei(帳票独自_市町村名表示有無);
            }
            RString 帳票独自_町域編集方法 = 帳票制御共通.getJushoHenshuChoikiHenshuHoho();
            div.setHdnChohyoDokujiHensyuHoho(帳票独自_町域編集方法);
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                RString 帳票独自_方書表示有無 = new RString("1");
                div.setHdnChohyoDokujiKatagaki(帳票独自_方書表示有無);
            }
        }
    }

    public void setradJushoSettei() {
        if (帳票独自.equals(div.getRadJushoSettei().getSelectedKey())) {
            div.getBtnAtesakiJushoSettei().setDisabled(true);
        } else {
            div.getBtnAtesakiJushoSettei().setDisabled(false);
        }
    }

    public boolean is帳票独自() {
        boolean 帳票独自フラグ = false;
        if (帳票独自.equals(div.getRadJushoSettei().getSelectedKey())) {
            帳票独自フラグ = true;
        }
        return 帳票独自フラグ;
    }

    public boolean is都道府県名表示() {
        if (is帳票独自()) {
            return new RString("1").equals(div.getHdnShichosonKyotsuTodofukenMei());
        } else {
            return new RString("1").equals(div.getHdnChohyoDokujiTodofukenMei());
        }
    }

    public boolean is郡名表示() {
        if (is帳票独自()) {
            return new RString("1").equals(div.getHdnShichosonKyotsuGunMei());
        } else {
            return new RString("1").equals(div.getHdnChohyoDokujiGunMei());
        }
    }

    public boolean is市町村名表示() {
        if (is帳票独自()) {
            return new RString("1").equals(div.getHdnShichosonKyotsuShichosonMei());
        } else {
            return new RString("1").equals(div.getHdnChohyoDokujiShichosonMei());
        }
    }

    public RString get町域編集方法() {
        if (is帳票独自()) {
            return div.getHdnShichosonKyotsuHensyuHoho();
        } else {
            return div.getHdnChohyoDokujiHensyuHoho();
        }
    }

    public boolean is方書表示() {
        if (is帳票独自()) {
            return new RString("1").equals(div.getHdnShichosonKyotsuKatagaki());
        } else {
            return new RString("1").equals(div.getHdnChohyoDokujiKatagaki());
        }
    }

    public void 宛先住所編集書式() {
        RStringBuilder 書式 = new RStringBuilder();
        if (is帳票独自()) {
            if (new RString("1").equals(div.getHdnShichosonKyotsuTodofukenMei())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋都道府県"));
                } else {
                    書式.append(new RString("都道府県"));
                }
            }
            if (new RString("1").equals(div.getHdnShichosonKyotsuGunMei())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋郡"));
                } else {
                    書式.append(new RString("郡"));
                }
            }
            if (new RString("1").equals(div.getHdnShichosonKyotsuShichosonMei())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋市町村"));
                } else {
                    書式.append(new RString("市町村"));
                }
            }
            if (new RString("1").equals(div.getHdnShichosonKyotsuKatagaki())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋方書"));
                } else {
                    書式.append(new RString("方書"));
                }
            }
            if (new RString("5").equals(div.getHdnShichosonKyotsuHensyuHoho())) {

            } else {
                if (new RString("1").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋住所＋番地"));
                    } else {
                        書式.append(new RString("住所＋番地"));
                    }
                } else if (new RString("2").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋行政区＋番地"));
                    } else {
                        書式.append(new RString("行政区＋番地"));
                    }
                } else if (new RString("3").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋住所＋番地、（行政区）"));
                    } else {
                        書式.append(new RString("住所＋番地、（行政区）"));
                    }
                } else if (new RString("4").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋番地のみ"));
                    } else {
                        書式.append(new RString("番地のみ"));
                    }
                }
            }
        } else {
            if (new RString("1").equals(div.getHdnShichosonKyotsuTodofukenMei())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋都道府県"));
                } else {
                    書式.append(new RString("都道府県"));
                }
            }
            if (new RString("1").equals(div.getHdnShichosonKyotsuGunMei())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋郡"));
                } else {
                    書式.append(new RString("郡"));
                }
            }
            if (new RString("1").equals(div.getHdnShichosonKyotsuShichosonMei())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋市町村"));
                } else {
                    書式.append(new RString("市町村"));
                }
            }
            if (new RString("1").equals(div.getHdnShichosonKyotsuKatagaki())) {
                if (書式.toRString().isEmpty()) {
                    書式.append(new RString("＋方書"));
                } else {
                    書式.append(new RString("方書"));
                }
            }
            if (new RString("5").equals(div.getHdnShichosonKyotsuHensyuHoho())) {

            } else {
                if (new RString("1").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋住所＋番地"));
                    } else {
                        書式.append(new RString("住所＋番地"));
                    }
                } else if (new RString("2").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋行政区＋番地"));
                    } else {
                        書式.append(new RString("行政区＋番地"));
                    }
                } else if (new RString("3").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋住所＋番地、（行政区）"));
                    } else {
                        書式.append(new RString("住所＋番地、（行政区）"));
                    }
                } else if (new RString("4").equals(div.getHdnShichosonKyotsuHensyuHoho())) {
                    if (書式.toRString().isEmpty()) {
                        書式.append(new RString("＋番地のみ"));
                    } else {
                        書式.append(new RString("番地のみ"));
                    }
                }
            }
        }
    }
}
