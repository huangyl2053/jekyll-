/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shinsakaijohokojin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaijohokojin.KaisaiKekkaAndBashoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaijohokojin.WariateIinAndIinJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.ShinsakaiJohoKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.dgHoketsuShinsakai_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaijohokojin.ShinsakaiJohoKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * ShinsakaiJohoKojinのHandlerクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public class ShinsakaiJohoKojinHandler {

    private final Code 議長 = new Code("1");
    private final ShinsakaiJohoKojinDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiJohoKojinDiv
     */
    public ShinsakaiJohoKojinHandler(ShinsakaiJohoKojinDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化を設定する。
     *
     */
    public void initialize() {
        KaisaiKekkaAndBashoJoho kaisai = new KaisaiKekkaAndBashoJoho(ShinsakaiJohoKojinFinder.createInstance().onLoad1(get申請書管理番号(), get審査会開催番号()));
        div.getTxtShinsakaiNo().setValue(kaisai.get介護認定審査会開催番号());
        div.getTxtGogitaiName().setValue(kaisai.get合議体名称());
        div.getTxtShinsakaijoMeisho().setValue(kaisai.get介護認定審査会開催場所名称());
        if (kaisai.get介護認定審査会開催地区コード() != null && !kaisai.get介護認定審査会開催地区コード().isEmpty()) {
            div.getTxtShinsakaijoChikuCode().setValue(new RString(kaisai.get介護認定審査会開催地区コード().toString()));
        }
        if (kaisai.get介護認定審査会開催地区コード() != null && !kaisai.get介護認定審査会開催地区コード().isEmpty()) {
            div.getTxtShinsakaijoChikuMeisho().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                    DBECodeShubetsu.審査会地区コード.getコード(), kaisai.get介護認定審査会開催地区コード()
            ));
        } else {
            div.getTxtShinsakaijoChikuMeisho().setValue(RString.EMPTY);
        }
        if (kaisai.get介護認定審査会開催年月日() != null && !kaisai.get介護認定審査会開催年月日().isEmpty()) {
            div.getTxtShinsaKaishiDay().setValue(kaisai.get介護認定審査会開催年月日().toRDate());
        }
        if (kaisai.get介護認定審査会開始時刻() != null && !kaisai.get介護認定審査会開始時刻().isEmpty()) {
            div.getTxtShinsaKaishiTime().setValue(new RTime(kaisai.get介護認定審査会開始時刻()));
        }
        if (kaisai.get介護認定審査会終了時刻() != null && !kaisai.get介護認定審査会終了時刻().isEmpty()) {
            div.getTxtShinsaShuryoTime().setValue(new RTime(kaisai.get介護認定審査会終了時刻()));
        }
        div.getTxtShinsaTime().setValue(new RString(String.valueOf(kaisai.get所要時間合計())));
        div.getDgShinsakaiIin().setDataSource(get審査会委員一覧データグリッド(kaisai));
        div.getDgHoketsuShinsakai().setDataSource(get補欠審査会委員一覧データグリッド(kaisai));
    }

    private ShinseishoKanriNo get申請書管理番号() {
            return new ShinseishoKanriNo(div.getHdnShinseishoKanriNo());
    }
    
     private RString get審査会開催番号() {
            return div.getHdnShinsakaiKaisaiNo();
    }

    private List<dgShinsakaiIin_Row> get審査会委員一覧データグリッド(KaisaiKekkaAndBashoJoho 開催情報) {
        List<WariateIinAndIinJoho> shinsakaijlist = ShinsakaiJohoKojinFinder.createInstance().onLoad2(
                開催情報.get合議体番号(), 開催情報.get介護認定審査会開催番号(), 開催情報.get介護認定審査会開催年月日()
        );
        dgShinsakaiIin_Row dgShin = new dgShinsakaiIin_Row();
        List<dgShinsakaiIin_Row> dgShinlist = new ArrayList<>();
        for (WariateIinAndIinJoho shinsakaij : shinsakaijlist) {
            if (議長.equals(shinsakaij.get介護認定審査会議長区分コード())) {
                dgShin.setIincho(Boolean.TRUE);
            }
            dgShin.setShinsakaiIinCode(shinsakaij.get介護認定審査会委員コード());
            if (shinsakaij.get介護認定審査会委員氏名() != null && !shinsakaij.get介護認定審査会委員氏名().isEmpty()) {
                dgShin.setShinsakaiIinShimei(shinsakaij.get介護認定審査会委員氏名().value());
            }
            get審査会委員資格(dgShin, shinsakaij);
            dgShinlist.add(dgShin);
            dgShin = new dgShinsakaiIin_Row();
        }
        return dgShinlist;
    }

    private dgShinsakaiIin_Row get審査会委員資格(dgShinsakaiIin_Row dgShin, WariateIinAndIinJoho shinsakaij) {
        if (shinsakaij.get介護認定審査員資格コード() != null && !shinsakaij.get介護認定審査員資格コード().isEmpty()) {
            if (Sikaku._准_看護師.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku._准_看護師.get名称());
            } else if (Sikaku.その他.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.その他.get名称());
            } else if (Sikaku.その他福祉関係者.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.その他福祉関係者.get名称());
            } else if (Sikaku.ソーシャルワーカー.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.ソーシャルワーカー.get名称());
            } else if (Sikaku.ホームヘルパー.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.ホームヘルパー.get名称());
            } else if (Sikaku.介護福祉士.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.介護福祉士.get名称());
            } else if (Sikaku.介護職員.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.介護職員.get名称());
            } else if (Sikaku.作業療法士.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.作業療法士.get名称());
            } else if (Sikaku.保健師.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
                dgShin.setShinsakaiIinShikaku(Sikaku.保健師.get名称());
            }
            get審査会委員資格2(dgShin, shinsakaij);
        }
        return dgShin;
    }

    private dgShinsakaiIin_Row get審査会委員資格2(dgShinsakaiIin_Row dgShin, WariateIinAndIinJoho shinsakaij) {
        if (Sikaku.助産師.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.助産師.get名称());
        } else if (Sikaku.医師.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.医師.get名称());
        } else if (Sikaku.歯科医師.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.歯科医師.get名称());
        } else if (Sikaku.理学療法士.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.理学療法士.get名称());
        } else if (Sikaku.社会福祉士.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.社会福祉士.get名称());
        } else if (Sikaku.福祉事務所現業員等.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.福祉事務所現業員等.get名称());
        } else if (Sikaku.薬剤師.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.薬剤師.get名称());
        } else if (Sikaku.行政関係者.getコード().equals(shinsakaij.get介護認定審査員資格コード().value())) {
            dgShin.setShinsakaiIinShikaku(Sikaku.行政関係者.get名称());
        }
        return dgShin;
    }

    private List<dgHoketsuShinsakai_Row> get補欠審査会委員一覧データグリッド(KaisaiKekkaAndBashoJoho 開催情報) {
        List<WariateIinAndIinJoho> kaijyouhoulist = ShinsakaiJohoKojinFinder.createInstance().onLoad3(
                開催情報.get合議体番号(), 開催情報.get介護認定審査会開催番号(), 開催情報.get介護認定審査会開催年月日()
        );
        dgHoketsuShinsakai_Row dgHoketsu = new dgHoketsuShinsakai_Row();
        List<dgHoketsuShinsakai_Row> dgHoketsulist = new ArrayList<>();
        for (WariateIinAndIinJoho kaijyouhou : kaijyouhoulist) {
            if (議長.equals(kaijyouhou.get介護認定審査会議長区分コード())) {
                dgHoketsu.setIincho(Boolean.TRUE);
            }
            dgHoketsu.setHoketsuShinsakaiIinCode(kaijyouhou.get介護認定審査会委員コード());
            if (kaijyouhou.get介護認定審査会委員氏名() != null && !kaijyouhou.get介護認定審査会委員氏名().isEmpty()) {
                dgHoketsu.setHoketsuShinsakaiIinShimei(kaijyouhou.get介護認定審査会委員氏名().value());
            }
            get補欠審査会委員資格(dgHoketsu, kaijyouhou);
            dgHoketsulist.add(dgHoketsu);
            dgHoketsu = new dgHoketsuShinsakai_Row();
        }
        return dgHoketsulist;
    }

    private dgHoketsuShinsakai_Row get補欠審査会委員資格(dgHoketsuShinsakai_Row dgHoketsu, WariateIinAndIinJoho kaijyouhou) {
        if (kaijyouhou.get介護認定審査員資格コード() != null && !kaijyouhou.get介護認定審査員資格コード().isEmpty()) {
            if (Sikaku._准_看護師.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku._准_看護師.get名称());
            } else if (Sikaku.その他.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.その他.get名称());
            } else if (Sikaku.その他福祉関係者.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.その他福祉関係者.get名称());
            } else if (Sikaku.ソーシャルワーカー.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.ソーシャルワーカー.get名称());
            } else if (Sikaku.ホームヘルパー.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.ホームヘルパー.get名称());
            } else if (Sikaku.介護福祉士.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.介護福祉士.get名称());
            } else if (Sikaku.介護職員.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.介護職員.get名称());
            } else if (Sikaku.作業療法士.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.作業療法士.get名称());
            } else if (Sikaku.保健師.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
                dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.保健師.get名称());
            }
            get補欠審査会委員資格2(dgHoketsu, kaijyouhou);
        }
        return dgHoketsu;
    }

    private dgHoketsuShinsakai_Row get補欠審査会委員資格2(dgHoketsuShinsakai_Row dgHoketsu, WariateIinAndIinJoho kaijyouhou) {
        if (Sikaku.助産師.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.助産師.get名称());
        } else if (Sikaku.医師.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.医師.get名称());
        } else if (Sikaku.歯科医師.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.歯科医師.get名称());
        } else if (Sikaku.理学療法士.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.理学療法士.get名称());
        } else if (Sikaku.社会福祉士.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.社会福祉士.get名称());
        } else if (Sikaku.福祉事務所現業員等.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.福祉事務所現業員等.get名称());
        } else if (Sikaku.薬剤師.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.薬剤師.get名称());
        } else if (Sikaku.行政関係者.getコード().equals(kaijyouhou.get介護認定審査員資格コード().value())) {
            dgHoketsu.setHoketsuShinsakaiIinShikaku(Sikaku.行政関係者.get名称());
        }
        return dgHoketsu;
    }
}
