/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseisonotaJohoInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DataKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SakujoJiyuCode;
import jp.co.ndensan.reams.db.dbz.realservice.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 共有子Div「申請その他情報」の実装クラスです。
 *
 * @author n8235 船山洋介
 */
public class ShinseiSonotaJohoInputHandler {

    private final ShinseiSonotaJohoInputDiv div;
    private final RString TSUJO_IDOJIYU_KEY = new RString("0");
    private final RString TORIKESHI_IDOJIYU_KEY = new RString("1");
    private final RString SHUTOKU_IDOJIYU_KEY = new RString("2");
    private final RString KYAKKA_IDOJIYU_KEY = new RString("3");
    private final RString SHINSEITORIKESHI_IDOJIYU_KEY = new RString("4");

    /**
     * コンストラクタです。
     *
     * @param div 申請その他情報Div
     */
    public ShinseiSonotaJohoInputHandler(ShinseiSonotaJohoInputDiv div) {
        this.div = div;
    }

    /**
     * 初期化を行います。
     */
    public void initialize() {
        hasSetMode();
        setInitialData();
    }

    private void setInitialData() {

        if (div.getHdnDatabaseSubGyomuCode().equals(SubGyomuCode.DBE認定支援.value())) {
            return;
        }

        JukyushaDaichoManager jukyushaDaichoManager = new JukyushaDaichoManager();
        Optional<JukyushaDaicho> 直近受給者台帳 = jukyushaDaichoManager.get直近受給者台帳(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));

        if (直近受給者台帳.isPresent()) {
            setChokkinJukyushaJoho(直近受給者台帳);
        }
    }

    private void setChokkinJukyushaJoho(Optional<JukyushaDaicho> 直近受給者台帳) {
        div.getDdlIdoJiyu().setSelectedKey(直近受給者台帳.get().getデータ区分().value());

        if (div.getMode_ShoriType().equals(ShinseiSonotaJohoInputDiv.ShoriType.TokushuSakujoMode)) {
            div.getDdlSakujoJiyu().setSelectedKey(直近受給者台帳.get().get削除事由コード().value());
        }

        div.getTxtRiyu().setValue(直近受給者台帳.get().get異動理由());
        div.getTxtSoshitsuDay().setValue(直近受給者台帳.get().get喪失年月日());
        div.getTxtTorikeshiDay().setValue(直近受給者台帳.get().get認定取消通知書発行年月日());
        div.getTxtToshoNinteiKikanFrom().setValue(直近受給者台帳.get().get当初認定有効開始年月日());
        div.getTxtToshoNinteiKikanTo().setValue(直近受給者台帳.get().get当初認定有効終了年月日());
        div.getTxtJukyuShikakuHakkoDay1().setValue(直近受給者台帳.get().get受給資格証明書発行年月日１());
        div.getTxtJukyuShikakuHakkoDay2().setValue(直近受給者台帳.get().get受給資格証明書発行年月日２());
    }

    /**
     * 入力値をクリアします。
     */
    public void clear() {
        div.getDdlIdoJiyu().setSelectedKey(DropDownList.BLANKLINE_KEY);
        if (div.getMode_ShoriType().equals(ShinseiSonotaJohoInputDiv.ShoriType.TokushuSakujoMode)) {
            div.getDdlSakujoJiyu().setSelectedKey(DropDownList.BLANKLINE_KEY);
        }
        div.getTxtRiyu().clearValue();
        div.getTxtSoshitsuDay().clearValue();
        div.getTxtTorikeshiDay().clearValue();
        div.getTxtToshoNinteiKikanFrom().clearValue();
        div.getTxtToshoNinteiKikanTo().clearValue();
        div.getTxtJukyuShikakuHakkoDay1().clearValue();
        div.getTxtJukyuShikakuHakkoDay2().clearValue();
    }

    private void hasSetMode() {
        switch (div.getMode_ShoriType()) {
            case TokushuTsuikaMode:
            case TokushuShuseiMode:
            case ShokkenKisaiMode:
                div.getDdlIdoJiyu().setDataSource(getDataKubunByStartWith(SHUTOKU_IDOJIYU_KEY));
                break;

            case NinteiMode:
                div.getDdlIdoJiyu().setDataSource(getDataKubunByStartWith(TSUJO_IDOJIYU_KEY));
                break;

            case KyakkaMode:
                div.getDdlIdoJiyu().setDataSource(getDataKubunByStartWith(KYAKKA_IDOJIYU_KEY));
                break;

            case TorikeshiMode:
                div.getDdlIdoJiyu().setDataSource(getDataKubunByStartWith(SHINSEITORIKESHI_IDOJIYU_KEY));
                break;

            case ShokkenTorikeshiMode:
            case SoshitsuMode:
                div.getDdlIdoJiyu().setDataSource(getDataKubunByStartWith(TORIKESHI_IDOJIYU_KEY));
                break;

            case TokushuSakujoMode:
                div.getDdlSakujoJiyu().setDataSource(getSakujoJiyuDataSource());
                div.getDdlIdoJiyu().setDataSource(getDataKubun());
                break;
            default:

            case TokushuRirekiShuseiMode:
            case JukyuShikakushashoMode:
            case ShokaiMode:
                div.getDdlIdoJiyu().setDataSource(getDataKubun());
                break;
        }

    }

    private List<KeyValueDataSource> getDataKubun() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (DataKubun target : DataKubun.values()) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(target.code(), target.toRString());
            dataSource.add(keyValueData);
        }
        return dataSource;

    }

    private List<KeyValueDataSource> getDataKubunByStartWith(RString startWith) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (DataKubun target : DataKubun.values()) {
            if (target.code().startsWith(startWith)) {
                dataSource.add(new KeyValueDataSource(target.code(), target.toRString()));
            }
        }
        return dataSource;

    }

    private List<KeyValueDataSource> getSakujoJiyuDataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (SakujoJiyuCode target : SakujoJiyuCode.values()) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(target.code(), target.toRString());
            dataSource.add(keyValueData);
        }
        return dataSource;
    }
}
