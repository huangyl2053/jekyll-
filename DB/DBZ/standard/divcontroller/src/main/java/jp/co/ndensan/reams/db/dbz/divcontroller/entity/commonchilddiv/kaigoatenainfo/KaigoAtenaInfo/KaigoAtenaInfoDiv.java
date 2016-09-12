package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IAtenaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.ShokaiDataDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoAtenaInfo のクラスファイル
 *
 * @reamsid_L DBA-0030-011 liangbc
 */
public class KaigoAtenaInfoDiv extends Panel implements IKaigoAtenaInfoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("atenaInfo")
    private AtenaShokaiSimpleDiv atenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getatenaInfo
     * @return atenaInfo
     */
    @JsonProperty("atenaInfo")
    public IAtenaShokaiSimpleDiv getAtenaInfo() {
        return atenaInfo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 介護宛名基本情報の初期化
     *
     * @param 識別コード 識別コード
     */
    @Override
    public void initialize(ShikibetsuCode 識別コード) {
        IAtesakiGyomuHanteiKey 業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険);
        IAtenaSearchKey 宛名検索キー = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登外優先, 業務判定キー).set識別コード(識別コード).build();
        getAtenaInfo().load(宛名検索キー);
        getAtenaInfo().onChangeDisplayMode三行タイプ();
    }

    /**
     * 氏名漢字を取得
     *
     * @return 氏名漢字
     */
    @Override
    public RString get氏名漢字() {
        return atenaInfo.getCcdMeishoHyoji().get漢字名称();
    }

    /**
     * 氏名カナを取得
     *
     * @return 氏名カナ
     */
    @Override
    public RString get氏名カナ() {
        return atenaInfo.getCcdMeishoHyoji().getカナ名称();
    }

    /**
     * 郵便番号を取得
     *
     * @return 郵便番号
     */
    @Override
    public YubinNo get郵便番号() {
        return atenaInfo.getShokaiData().getTxtYubinNo().getValue();
    }

    /**
     * 住所を取得
     *
     * @return 住所
     */
    @Override
    public AtenaJusho get住所() {
        return new AtenaJusho(atenaInfo.getShokaiData().getTxtJusho().getValue());
    }

    /**
     * ShokaiDataを取得
     *
     * @return ShokaiData
     */
    @Override
    public ShokaiDataDiv getShokaiData() {
        return atenaInfo.getShokaiData();
    }

    /**
     * 宛名情報を取得
     *
     * @return 宛名情報
     */
    @Override
    public AtenaShokaiSimpleDiv getAtenaInfoDiv() {
        return atenaInfo;
    }
}
