package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoNinteiShinseishaInfo のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoNinteiShinseishaInfoDiv extends Panel implements IKaigoNinteiShinseishaInfoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("hdnKaigoDonyuDantaiKeitai")
    private RString hdnKaigoDonyuDantaiKeitai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * gethdnKaigoDonyuDantaiKeitai
     * @return hdnKaigoDonyuDantaiKeitai
     */
    @JsonProperty("hdnKaigoDonyuDantaiKeitai")
    public RString getHdnKaigoDonyuDantaiKeitai() {
        return hdnKaigoDonyuDantaiKeitai;
    }

    /*
     * sethdnKaigoDonyuDantaiKeitai
     * @param hdnKaigoDonyuDantaiKeitai hdnKaigoDonyuDantaiKeitai
     */
    @JsonProperty("hdnKaigoDonyuDantaiKeitai")
    public void setHdnKaigoDonyuDantaiKeitai(RString hdnKaigoDonyuDantaiKeitai) {
        this.hdnKaigoDonyuDantaiKeitai = hdnKaigoDonyuDantaiKeitai;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum AtenaType implements ICommonChildDivMode {

        AtenaMode("AtenaMode"),
        AtenNoneMode("AtenNoneMode");

        private final String name;

        private AtenaType(final String name) {
            this.name = name;
        }

        public static AtenaType getEnum(String str) {
            AtenaType[] enumArray = AtenaType.values();

            for (AtenaType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public AtenaType getMode_AtenaType() {
        return (AtenaType) _CommonChildDivModeUtil.getMode(this.modes, AtenaType.class);
    }

    public void setMode_AtenaType(AtenaType value) {
        _CommonChildDivModeUtil.setMode(this.modes, AtenaType.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private static final RString 連絡先ボタンを = new RString("RenrakusakiAriMode");
    private static final RString 認定履歴ボタンを = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタンを = new RString("NinteirirekiNashiMode");

    @Override
    public void load(RString 介護導入形態, RString 処理タイプ, ShikibetsuCode 識別コード, ShinseishoKanriNo 申請書管理番号, HihokenshaNo 被保険者番号, RString 表示モード) {
       kaigoNinteiAtenaInfo_onload(介護導入形態, 処理タイプ, 識別コード, 申請書管理番号);
       kaigoShikakuKihon_onload(被保険者番号, 表示モード);
    }
    
    private void kaigoShikakuKihon_onload(HihokenshaNo 被保険者番号, RString 表示モード){
         if (!RString.isNullOrEmpty(表示モード)) {
            if (連絡先ボタンを.equals(表示モード)) {
                getCcdKaigoShikakuKihon().set連絡先ボタンDisable(false);
                getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
                getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
            } else if (認定履歴ボタンを.equals(表示モード)) {
                getCcdKaigoShikakuKihon().set連絡先ボタンDisable(true);
                getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(false);
                getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
            } else if (被保履歴ボタンを.equals(表示モード)) {
                getCcdKaigoShikakuKihon().set連絡先ボタンDisable(true);
                getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
                getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(false);
            }
        }

        // 楊さん指示より、以下実行です。
        if (!RString.isNullOrEmpty(被保険者番号.getColumnValue())) {
            getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        }
    }
    
    private void kaigoNinteiAtenaInfo_onload(RString 介護導入形態, RString 処理タイプ, ShikibetsuCode 識別コード, ShinseishoKanriNo 申請書管理番号){
        getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        getCcdKaigoNinteiAtenaInfo().setShoriType(処理タイプ);
        getCcdKaigoNinteiAtenaInfo().initialize();
        getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(申請書管理番号, 識別コード);
    }
    
}
