package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiHandler;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.kojin.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「減免減額申請」のDivControllerです。
 *
 * @reamsid_L DBD-4341-010 xuyue
 */
public class GemmenGengakuShinsei {

    /**
     * 「事業者検索ボタン」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GemmenGengakuShinseiDiv> onBeforeOpenDialog_btnOpenJigyoshaGuide(GemmenGengakuShinseiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された事業者情報を当該項目の値を反映します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GemmenGengakuShinseiDiv> onOkClose_btnOpenJigyoshaGuide(GemmenGengakuShinseiDiv div) {
        div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(div.getJigyoshaCode());
        div.getCcdShisetsuJoho().setShisetsuMeisho(div.getJigyoshaMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 「本人情報で設定する」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GemmenGengakuShinseiDiv> onclick_txtCopyHonnin(GemmenGengakuShinseiDiv div) {
        ShikibetsuCode 本人識別コード = getHandler(div).get本人識別コード();
        boolean exist本人識別コード = !本人識別コード.isEmpty();
        if (exist本人識別コード) {
            IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.
                    createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
            ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー);
            builder.set識別コード(本人識別コード);
            IShikibetsuTaishoSearchKey 識別対象検索キー = builder.build();

            IKojinFinder finder = ShikibetsuTaishoService.getKojinFinder();
            List<IKojin> kojinList = finder.get個人s(識別対象検索キー);

            if (kojinList.isEmpty()) {
                return ResponseData.of(div).respond();
            }

            IKojin kojin = kojinList.get(0);
            div.getTxtShinseishaShimeiKana().setValue(kojin.get名称().getKana().getColumnValue());
            div.getTxtShinseishaShimei().setDomain(kojin.get名称().getName());
            div.getTxtShinseishaTsuzukigara().setValue(new RString("本人"));
            div.getTxtShinseishaYubinNo().setValue(kojin.get住所().get郵便番号());
            div.getTxtShinseishaTelNo().setDomain(kojin.get連絡先１());
            div.getTxtShinseishaJusho().setDomain(new AtenaJusho(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().value())
                    .concat(RString.FULL_SPACE).concat(kojin.get住所().get方書().value())));

        }
        return ResponseData.of(div).respond();
    }

    private GemmenGengakuShinseiHandler getHandler(GemmenGengakuShinseiDiv div) {
        return new GemmenGengakuShinseiHandler(div);
    }

}
