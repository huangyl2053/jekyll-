/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.parentdiv.dbu0600011;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoShokaiFukaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoShokaiInfoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoShokaiJuminDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoShokaiJuminKyokaiKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoShokaiJuminSogoJigyoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiFukaList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiJukyuGenmenGengakuList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiJukyuKyufuSeigenList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiJukyuNinteiList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiJukyuShisetsuNyushoList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiJuminKyokaiKanriList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiKyufuKagoMoushitateshoList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiKyufuKogakuKaigoServiceList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiKyufuShokanBaraiList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiShikakuJogaiList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiShikakuTokureiList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.dgSogoShokaiShikakuTokusoList_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tabSogoShokaiJukyuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tabSogoShokaiKyufuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tabSogoShokaiShikakuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiJukyuGenmenGengakuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiJukyuKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiJukyuNinteiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiJukyuShisetsuNyushoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiKyufuKagoMoushitateshoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiKyufuKogakuKaigoServiceDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiKyufuKyotakuServiceKeikakuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiKyufuSaishinsaMoushitateshoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiKyufuShokanBaraiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiShikakuJogaiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiShikakuTokureiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.tplSogoShokaiShikakuTokusoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiFukaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiFukaTokubetsuChoshuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiFukushiYoguKonyuhiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKagoMoshitateHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKagoMoshitateJiyuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKagoMoshitateKohiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKagoMoushitateInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKogakuFurikomiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKogakuKaigoServicehiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKogakuKokuhorenKetteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKogakuKokuhorenSofuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKyotakuServiceKeikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKyufuSeigenGengakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKyufuSeigenHenkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiKyufuSeigenInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiNinteiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiSaishinsaHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiSaishinsaJiyuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiSaishinsaKohiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiSaishinsaMoushitateInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SogoShokaiShisetsuNyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dbz0010000.SogoShokaiGenmenGengakuFutanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dbz0010000.SogoShokaiGenmenGengakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dbz0010000.SogoShokaiGenmenGengakuTechoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dbz0010000.SogoShokaiIryoHokenKanyuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dbz0010000.SogoShokaiJutakuKaishuhiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dbz0010000.dgSogoShokaiHokenKanyuList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dgYoguSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.tblFukaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.tblFutsuChoshuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.tblTokubetsuChoshuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.tblYoguSeikyuSummaryDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;

/**
 * 総合照会情報のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class SogoShokaiInfo {

    private static final int TYPE_SHIKAKU = 1;
    private static final int TYPE_JUKYU = 2;
    private static final int TYPE_KYUFU = 3;
    private static final int TYPE_FUKA = 4;
    private static final int TYPE_JUMIN = 5;

    private static final RString YML_SHIKAKU_TOKUSO = new RString("dbu0600011/ShikakuTokusoData.yml");
    private static final RString YML_IRYO_HOKEN_KANYU = new RString("dbu0600011/IryoHokenKanyuData.yml");
    private static final RString YML_TAJUSHOCHI_TOKUREI = new RString("dbu0600011/TajushochiTokureiData.yml");
    private static final RString YML_JOGAI_TEKIYO = new RString("dbu0600011/JogaiTekiyoData.yml");
    private static final RString YML_NINTEI = new RString("dbu0600011/NinteiData.yml");
    private static final RString YML_GENMEN_GENGAKU = new RString("dbu0600011/GenmenGengakuData.yml");
    private static final RString YML_SHISETSU_NYUSHO = new RString("dbu0600011/ShisetsuNyushoData.yml");
    private static final RString YML_KYUFU_SEIGEN = new RString("dbu0600011/KyufuSeigenData.yml");
    private static final RString YML_SERVICE_KEIKAKU = new RString("dbu0600011/ServiceKeikakuData.yml");
    private static final RString YML_KOGAKU_SERVICE = new RString("dbu0600011/KogakuServiceData.yml");
    private static final RString YML_SHOKAN_BARAI = new RString("dbu0600011/ShokanBaraiData.yml");
    private static final RString YML_YOGU_KONYUHI = new RString("dbu0600011/FukushiYoguKonyuhiData.yml");
    private static final RString YML_YOGU_KONYUHI_MEISAI = new RString("dbu0600011/FukushiYoguKonyuhiMeisaiData.yml");
    private static final RString YML_KAGO_MOUSHITATE = new RString("dbu0600011/KagoMoushitateshoData.yml");
    private static final RString YML_SAISHIN_MOUSHITATE = new RString("dbu0600011/SaishinsaMoushitateshoData.yml");
    private static final RString YML_FUKA = new RString("dbu0600011/FukaData.yml");
    private static final RString YML_KYOKAISO_KANRI = new RString("dbu0600011/KyokaisoKanriData.yml");
    private static final RString YML_SOGO_JIGYO_TAISHOSHA = new RString("dbu0600011/SogoJigyoTaishoshaData.yml");
    private static final RString 入所日 = new RString("入所日");
    private static final RString 退所日 = new RString("退所日");
    private static final RString 申請日 = new RString("申請日");
    private static final RString 適用開始日 = new RString("適用開始日");
    private static final RString 決定日 = new RString("決定日");
    private static final RString 事業者名称 = new RString("事業者名称");
    private static final RString 事業者コード = new RString("事業者コード");
    private static final RString 提供年月 = new RString("提供年月");
    private static final RString 申立日 = new RString("申立日");
    private static final RString サービス提供年月 = new RString("サービス提供年月");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiInfoDiv> onLoad(SogoShokaiInfoDiv panel) {
        ResponseData<SogoShokaiInfoDiv> response = new ResponseData<>();

        setSogoShokaiInfo(panel, TYPE_SHIKAKU);

        setShikakuInfo(panel.getSogoShokaiShikaku().getTabSogoShokaiShikaku());
        setJukyuInfo(panel.getSogoShokaiJukyu().getTabSogoShokaiJukyu());
        setKyufuInfo(panel.getSogoShokaiKyufu().getTabSogoShokaiKyufu());
        setFukaInfo(panel.getSogoShokaiFuka());
        setJuminInfo(panel.getSogoShokaiJumin());

        response.data = panel;
        return response;
    }

    /**
     * 資格情報を表示するボタンクリック時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiInfoDiv> onClick_btnShikakuInfo(SogoShokaiInfoDiv panel) {
        ResponseData<SogoShokaiInfoDiv> response = new ResponseData<>();

        setSogoShokaiInfo(panel, TYPE_SHIKAKU);

        response.data = panel;
        return response;
    }

    /**
     * 受給情報を表示するボタンクリック時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiInfoDiv> onClick_btnJukyuInfo(SogoShokaiInfoDiv panel) {
        ResponseData<SogoShokaiInfoDiv> response = new ResponseData<>();

        setSogoShokaiInfo(panel, TYPE_JUKYU);

        response.data = panel;
        return response;
    }

    /**
     * 給付情報を表示するボタンクリック時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiInfoDiv> onClick_btnKyufuInfo(SogoShokaiInfoDiv panel) {
        ResponseData<SogoShokaiInfoDiv> response = new ResponseData<>();

        setSogoShokaiInfo(panel, TYPE_KYUFU);

        response.data = panel;
        return response;
    }

    /**
     * 賦課情報を表示するボタンクリック時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiInfoDiv> onClick_btnFukaInfo(SogoShokaiInfoDiv panel) {
        ResponseData<SogoShokaiInfoDiv> response = new ResponseData<>();

        setSogoShokaiInfo(panel, TYPE_FUKA);

        response.data = panel;
        return response;
    }

    /**
     * 住民情報を表示するボタンクリック時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiInfoDiv> onClick_btnJuminInfo(SogoShokaiInfoDiv panel) {
        ResponseData<SogoShokaiInfoDiv> response = new ResponseData<>();

        setSogoShokaiInfo(panel, TYPE_JUMIN);

        response.data = panel;
        return response;
    }

    /**
     * 医療保険加入情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiIryoHokenKanyuInfoDiv> onLoad_IryoHokenKanyuInfo(SogoShokaiIryoHokenKanyuInfoDiv panel) {
        ResponseData<SogoShokaiIryoHokenKanyuInfoDiv> response = new ResponseData<>();

        setIryoHokenKanyuInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 認定情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiNinteiInfoDiv> onLoad_NinteiInfo(SogoShokaiNinteiInfoDiv panel) {
        ResponseData<SogoShokaiNinteiInfoDiv> response = new ResponseData<>();

        setJukyuNinteiDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 減免・減額情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiGenmenGengakuInfoDiv> onLoad_GenmenGengakuInfo(SogoShokaiGenmenGengakuInfoDiv panel) {
        ResponseData<SogoShokaiGenmenGengakuInfoDiv> response = new ResponseData<>();

        setJukyuGenmenGengakuDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 施設入所情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiShisetsuNyushoInfoDiv> onLoad_ShisetsuNyushoInfo(SogoShokaiShisetsuNyushoInfoDiv panel) {
        ResponseData<SogoShokaiShisetsuNyushoInfoDiv> response = new ResponseData<>();

        setJukyuShisetsuNyushoDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 給付制限情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiKyufuSeigenInfoDiv> onLoad_KyufuSeigenInfo(SogoShokaiKyufuSeigenInfoDiv panel) {
        ResponseData<SogoShokaiKyufuSeigenInfoDiv> response = new ResponseData<>();

        setJukyuKyufuSeigenDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 居宅サービス計画情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiKyotakuServiceKeikakuInfoDiv> onLoad_KyotakuServiceKeikakuInfo(SogoShokaiKyotakuServiceKeikakuInfoDiv panel) {
        ResponseData<SogoShokaiKyotakuServiceKeikakuInfoDiv> response = new ResponseData<>();

        setKyufuKyotakuServiceKeikakuDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 高額介護サービス費情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiKogakuKaigoServicehiInfoDiv> onLoad_KogakuKaigoServicehiInfo(SogoShokaiKogakuKaigoServicehiInfoDiv panel) {
        ResponseData<SogoShokaiKogakuKaigoServicehiInfoDiv> response = new ResponseData<>();

        setKyufuKogakuKaigoServiceDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 福祉用具購入費情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiFukushiYoguKonyuhiInfoDiv> onLoad_FukushiYoguKonyuhiInfo(SogoShokaiFukushiYoguKonyuhiInfoDiv panel) {
        ResponseData<SogoShokaiFukushiYoguKonyuhiInfoDiv> response = new ResponseData<>();

        setFukushiYoguKonyuhiDetailInfo(panel, 0);

        response.data = panel;
        return response;
    }

    /**
     * 福祉用具購入費明細情報選択時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiFukushiYoguKonyuhiInfoDiv> onClick_btnSelectYoguKonyuhi(SogoShokaiFukushiYoguKonyuhiInfoDiv panel) {
        ResponseData<SogoShokaiFukushiYoguKonyuhiInfoDiv> response = new ResponseData<>();

        setFukushiYoguKonyuhiDetailInfo(panel, panel.getDgYoguSeikyuDetail().getClickedRowId());

        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiJutakuKaishuhiInfoDiv> onLoad_JutakuKaishuhiInfo(SogoShokaiJutakuKaishuhiInfoDiv panel) {
        ResponseData<SogoShokaiJutakuKaishuhiInfoDiv> response = new ResponseData<>();

        response.data = panel;
        return response;
    }

    /**
     * 過誤申立情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiKagoMoushitateInfoDiv> onLoad_KagoMoushitateInfo(SogoShokaiKagoMoushitateInfoDiv panel) {
        ResponseData<SogoShokaiKagoMoushitateInfoDiv> response = new ResponseData<>();

        setKyufuKagoMoushitateshoDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 再審査申立情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiSaishinsaMoushitateInfoDiv> onLoad_SaishinsaMoushitateInfo(SogoShokaiSaishinsaMoushitateInfoDiv panel) {
        ResponseData<SogoShokaiSaishinsaMoushitateInfoDiv> response = new ResponseData<>();

        setKyufuSaishinsaMoushitateshoDetailInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 賦課情報ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiFukaInfoDiv> onLoad_FukaInfo(SogoShokaiFukaInfoDiv panel) {
        ResponseData<SogoShokaiFukaInfoDiv> response = new ResponseData<>();

        setFukaDetailInfo(panel);

        response.data = panel;
        return response;
    }

    // Yamlデータを取得する
    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBU.loadAsList(yamlName);
    }

    // 総合照会の情報を切り替える
    private void setSogoShokaiInfo(SogoShokaiInfoDiv panel, int type) {

        panel.getBtnShikakuInfo().setDisabled(false);
        panel.getSogoShokaiShikaku().setVisible(false);
        panel.getSogoShokaiShikaku().setDisplayNone(true);

        panel.getBtnJukyuInfo().setDisabled(false);
        panel.getSogoShokaiJukyu().setVisible(false);
        panel.getSogoShokaiJukyu().setDisplayNone(true);

        panel.getBtnKyufuInfo().setDisabled(false);
        panel.getSogoShokaiKyufu().setVisible(false);
        panel.getSogoShokaiKyufu().setDisplayNone(true);

        panel.getBtnFukaInfo().setDisabled(false);
        panel.getSogoShokaiFuka().setVisible(false);
        panel.getSogoShokaiFuka().setDisplayNone(true);

        panel.getBtnJuminInfo().setDisabled(false);
        panel.getSogoShokaiJumin().setVisible(false);
        panel.getSogoShokaiJumin().setDisplayNone(true);

        switch (type) {
            case TYPE_SHIKAKU:
                panel.setTitle(new RString("資格情報"));
                panel.getBtnShikakuInfo().setDisabled(true);
                panel.getSogoShokaiShikaku().setVisible(true);
                panel.getSogoShokaiShikaku().setDisplayNone(false);
                break;
            case TYPE_JUKYU:
                panel.setTitle(new RString("受給情報"));
                panel.getBtnJukyuInfo().setDisabled(true);
                panel.getSogoShokaiJukyu().setVisible(true);
                panel.getSogoShokaiJukyu().setDisplayNone(false);
                break;
            case TYPE_KYUFU:
                panel.setTitle(new RString("給付情報"));
                panel.getBtnKyufuInfo().setDisabled(true);
                panel.getSogoShokaiKyufu().setVisible(true);
                panel.getSogoShokaiKyufu().setDisplayNone(false);
                break;
            case TYPE_FUKA:
                panel.setTitle(new RString("賦課情報"));
                panel.getBtnFukaInfo().setDisabled(true);
                panel.getSogoShokaiFuka().setVisible(true);
                panel.getSogoShokaiFuka().setDisplayNone(false);
                break;
            case TYPE_JUMIN:
                panel.setTitle(new RString("住民情報"));
                panel.getBtnJuminInfo().setDisabled(true);
                panel.getSogoShokaiJumin().setVisible(true);
                panel.getSogoShokaiJumin().setDisplayNone(false);
                break;
            default:
                break;
        }

    }

    // 資格情報を設定する
    private void setShikakuInfo(tabSogoShokaiShikakuDiv panel) {
        setShikakuTokusoInfo(panel.getTplSogoShokaiShikakuTokuso());
        setShikakuTokureiInfo(panel.getTplSogoShokaiShikakuTokurei());
        setShikakuJogaiInfo(panel.getTplSogoShokaiShikakuJogai());
    }

    // 受給情報を設定する
    private void setJukyuInfo(tabSogoShokaiJukyuDiv panel) {
        setJukyuNinteiInfo(panel.getTplSogoShokaiJukyuNintei());
        setJukyuGenmenGengakuInfo(panel.getTplSogoShokaiJukyuGenmenGengaku());
        setJukyuShisetsuNyushoInfo(panel.getTplSogoShokaiJukyuShisetsuNyusho());
        setJukyuKyufuSeigenInfo(panel.getTplSogoShokaiJukyuKyufuSeigen());
    }

    // 給付情報を設定する
    private void setKyufuInfo(tabSogoShokaiKyufuDiv panel) {
        setKyufuKyotakuServiceKeikakuInfo(panel.getTplSogoShokaiKyufuKyotakuServiceKeikaku());
        setKyufuKogakuKaigoServiceInfo(panel.getTplSogoShokaiKyufuKogakuKaigoService());
        setKyufuShokanBaraiInfo(panel.getTplSogoShokaiKyufuShokanBarai());
        setKyufuKagoMoushitateshoInfo(panel.getTplSogoShokaiKyufuKagoMoushitatesho());
        setKyufuSaishinsaMoushitateshoInfo(panel.getTplSogoShokaiKyufuSaishinsaMoushitatesho());
    }

    // 住民情報を設定する
    private void setJuminInfo(SogoShokaiJuminDiv panel) {
        setJuminKyokaiKanriInfo(panel.getSogoShokaiJuminKyokaiKanri());
        setJuminSogoJigyoInfo(panel.getSogoShokaiJuminSogoJigyo());
    }

    // 資格：介護資格得喪情報を設定する
    private void setShikakuTokusoInfo(tplSogoShokaiShikakuTokusoDiv panel) {
        List<HashMap> mapList = getYamlData(YML_SHIKAKU_TOKUSO);
        List<dgSogoShokaiShikakuTokusoList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createShikakuTokusoListRow(
                    map.get("被保険者区分").toString(),
                    map.get("取得事由").toString(),
                    map.get("取得届出日").toString(),
                    map.get("取得日").toString(),
                    map.get("喪失事由").toString(),
                    map.get("喪失届出日").toString(),
                    map.get("喪失日").toString(),
                    map.get("第1号被保険者年齢到達日").toString(),
                    map.get("変更事由").toString(),
                    map.get("変更届出日").toString(),
                    map.get("変更日").toString(),
                    map.get("住所地特例適用事由").toString(),
                    map.get("適用届出日").toString(),
                    map.get("適用日").toString(),
                    map.get("住所地特例解除事由").toString(),
                    map.get("解除届出日").toString(),
                    map.get("解除日").toString(),
                    map.get("広住特措置元保険者").toString(),
                    map.get("旧保険者").toString(),
                    map.get("再交付区分").toString(),
                    map.get("再交付事由").toString(),
                    map.get("帳票交付履歴ID").toString()));
        }
        panel.getDgSogoShokaiShikakuTokusoList().setDataSource(list);
    }

    // 資格：介護資格得喪情報を作成する
    private dgSogoShokaiShikakuTokusoList_Row createShikakuTokusoListRow(
            String hihokenshaKubun,
            String shutokuJiyu,
            String shutokuTodokedeYMD,
            String shutokuYMD,
            String soshitsuJiyu,
            String soshitsuTodokedeYMD,
            String soshitsuYMD,
            String ichigoTotatsuYMD,
            String henkoJiyu,
            String henkoTodokedeYMD,
            String henkoYMD,
            String jushochitokureiTekiyoJiyu,
            String tekiyoTodokedeYMD,
            String tekiyoYMD,
            String jushochitokureiKaijoJiyu,
            String kaijoTodokedeYMD,
            String kaijoYMD,
            String koikinaiTokureiHokensha,
            String kyuHokensha,
            String saikofuKubun,
            String saikohuJiyu,
            String chohyoKofuRirekiID) {
        return new dgSogoShokaiShikakuTokusoList_Row(
                new RString(hihokenshaKubun),
                new RString(shutokuJiyu),
                new RString(shutokuTodokedeYMD),
                new RString(shutokuYMD),
                new RString(soshitsuJiyu),
                new RString(soshitsuTodokedeYMD),
                new RString(soshitsuYMD),
                new RString(ichigoTotatsuYMD),
                new RString(henkoJiyu),
                new RString(henkoTodokedeYMD),
                new RString(henkoYMD),
                new RString(jushochitokureiTekiyoJiyu),
                new RString(tekiyoTodokedeYMD),
                new RString(tekiyoYMD),
                new RString(jushochitokureiKaijoJiyu),
                new RString(kaijoTodokedeYMD),
                new RString(kaijoYMD),
                new RString(koikinaiTokureiHokensha),
                new RString(kyuHokensha),
                new RString(saikofuKubun),
                new RString(saikohuJiyu),
                new RString(chohyoKofuRirekiID));
    }

    // 資格：医療保険加入情報を設定する
    private void setIryoHokenKanyuInfo(SogoShokaiIryoHokenKanyuInfoDiv panel) {
        List<HashMap> mapList = getYamlData(YML_IRYO_HOKEN_KANYU);
        List<dgSogoShokaiHokenKanyuList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createSogoShokaiHokenKanyuListRow(
                    map.get("保険種別").toString(),
                    map.get("保険者番号").toString(),
                    map.get("保険者名").toString(),
                    map.get("記号番号").toString()
            ));
        }
        panel.getDgSogoShokaiHokenKanyuList().setDataSource(list);
    }

    // 医療保険加入情報を作成する
    private dgSogoShokaiHokenKanyuList_Row createSogoShokaiHokenKanyuListRow(
            String txtHokenShubetsu,
            String txtHokenshaNo,
            String txtHokenshaName,
            String txtKigoNo) {
        return new dgSogoShokaiHokenKanyuList_Row(
                new RString(txtHokenShubetsu),
                new RString(txtHokenshaNo),
                new RString(txtHokenshaName),
                new RString(txtKigoNo));
    }

    // 資格：他市町村住所地特例情報を設定する
    private void setShikakuTokureiInfo(tplSogoShokaiShikakuTokureiDiv panel) {
        List<HashMap> mapList = getYamlData(YML_TAJUSHOCHI_TOKUREI);
        List<dgSogoShokaiShikakuTokureiList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createShikakuTokureiListRow(
                    map.get("適用事由").toString(),
                    map.get("適用日").toString(),
                    map.get("適用届出日").toString(),
                    map.get("解除事由").toString(),
                    map.get("解除日").toString(),
                    map.get("解除届出日").toString(),
                    map.get("保険者").toString(),
                    map.get("被保番号").toString(),
                    map.get(入所日.toString()).toString(),
                    map.get(退所日.toString()).toString(),
                    map.get("施設種類").toString(),
                    map.get("入所施設").toString()
            ));
        }
        panel.getDgSogoShokaiShikakuTokureiList().setDataSource(list);
    }

    // 資格：他市町村住所地特例情報を作成する
    private dgSogoShokaiShikakuTokureiList_Row createShikakuTokureiListRow(
            String tekiyoJiyu,
            String tekiyoDate,
            String tekiyoTodokedeDate,
            String kaijoJiyu,
            String kaijoDate,
            String kaijoTodokedeDate,
            String sochiHokenshaMeisho,
            String sochiHihokenshaNo,
            String nyushoDate,
            String taishoDate,
            String shisetsuShurui,
            String nyushoShisetsu) {
        return new dgSogoShokaiShikakuTokureiList_Row(
                new RString(tekiyoJiyu),
                new RString(tekiyoDate),
                new RString(tekiyoTodokedeDate),
                new RString(kaijoJiyu),
                new RString(kaijoDate),
                new RString(kaijoTodokedeDate),
                new RString(sochiHokenshaMeisho),
                new RString(sochiHihokenshaNo),
                new RString(nyushoDate),
                new RString(taishoDate),
                new RString(shisetsuShurui),
                new RString(nyushoShisetsu));
    }

    // 資格：除外適用情報を設定する
    private void setShikakuJogaiInfo(tplSogoShokaiShikakuJogaiDiv panel) {
        List<HashMap> mapList = getYamlData(YML_JOGAI_TEKIYO);
        List<dgSogoShokaiShikakuJogaiList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createShikakuJogaiListRow(
                    map.get("適用事由").toString(),
                    map.get("適用日").toString(),
                    map.get("適用届出日").toString(),
                    map.get("解除事由").toString(),
                    map.get("解除適用日").toString(),
                    map.get("解除届出日").toString(),
                    map.get(入所日).toString(),
                    map.get(退所日.toString()).toString(),
                    map.get("施設").toString()));
        }
        panel.getDgSogoShokaiShikakuJogaiList().setDataSource(list);
    }

    // 資格：除外適用情報を作成する
    private dgSogoShokaiShikakuJogaiList_Row createShikakuJogaiListRow(
            String tekiyoJiyu,
            String tekiyoDate,
            String tekiyoTodokedeDate,
            String kaijoJiyu,
            String kaijoDate,
            String kaijoTodokedeDate,
            String nyushoDate,
            String taishoDate,
            String shisetsu) {
        return new dgSogoShokaiShikakuJogaiList_Row(
                new RString(tekiyoJiyu),
                new RString(tekiyoDate),
                new RString(tekiyoTodokedeDate),
                new RString(kaijoJiyu),
                new RString(kaijoDate),
                new RString(kaijoTodokedeDate),
                new RString(nyushoDate),
                new RString(taishoDate),
                new RString(shisetsu));
    }

    // 受給：認定情報を設定する
    private void setJukyuNinteiInfo(tplSogoShokaiJukyuNinteiDiv panel) {
        List<HashMap> mapList = getYamlData(YML_NINTEI);
        List<dgSogoShokaiJukyuNinteiList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createJukyuNinteiListRow(
                    map.get(申請日.toString()).toString(),
                    map.get("申請区分(法令)").toString(),
                    map.get("申請有効区分").toString(),
                    map.get("認定日").toString(),
                    map.get("状態区分").toString(),
                    map.get("有効開始日").toString(),
                    map.get("有効終了日").toString()));
        }
        panel.getDgSogoShokaiJukyuNinteiList().setDataSource(list);
    }

    // 受給：認定詳細情報を設定する
    private void setJukyuNinteiDetailInfo(SogoShokaiNinteiInfoDiv panel) {
        HashMap map = getYamlData(YML_NINTEI).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);

        //panel.getTxtNinteiShinseiYMD().setValue(new RDate(map.get(申請日.toString()).toString()));
        panel.getTxtNinteiShinseiYMD().setValue(ymlData.getAsRDate(申請日.toString()));
        panel.getTxtNinteiShinseiKubun().setValue(new RString(map.get("申請区分(法令)").toString()));
        panel.getTxtNinteiYukoKubun().setValue(new RString(map.get("申請有効区分").toString()));
        //panel.getTxtNinteiChosaJissiYMD().setValue(new RDate(map.get("調査実施日").toString()));
        panel.getTxtNinteiChosaJissiYMD().setValue(ymlData.getAsRDate("調査実施日"));
        //panel.getTxtNinteiChosaJuryoYMD().setValue(new RDate(map.get("調査受領日").toString()));
        panel.getTxtNinteiChosaJuryoYMD().setValue(ymlData.getAsRDate("調査受領日"));
        //panel.getTxtNinteiChosaKanryoYMD().setValue(new RDate(map.get("調査完了日").toString()));
        panel.getTxtNinteiChosaKanryoYMD().setValue(ymlData.getAsRDate("調査完了日"));
        panel.getTxtNinteiChosaItakusaki().setValue(new RString(map.get("調査委託先").toString()));
        panel.getTxtNinteiChosain().setValue(new RString(map.get("調査員").toString()));
        panel.getTxtNinteiShujii().setValue(new RString(map.get("主治医").toString()));
        panel.getTxtNinteiShujiiIryoKikan().setValue(new RString(map.get("主治医医療機関").toString()));
        //panel.getTxtNinteiIkenshoJuryoYMD().setValue(new RDate(map.get("意見書受領日").toString()));
        panel.getTxtNinteiIkenshoJuryoYMD().setValue(ymlData.getAsRDate("意見書受領日"));
        //panel.getTxtNinteiIkenshoKanryoYMD().setValue(new RDate(map.get("意見書登録完了日").toString()));
        panel.getTxtNinteiIkenshoKanryoYMD().setValue(ymlData.getAsRDate("意見書登録完了日"));
        panel.getTxtNinteiIchijiHantei().setValue(new RString(map.get("一次判定結果").toString()));
        panel.getTxtNinteiIchijiHanteiNinchi().setValue(new RString(map.get("一次判定結果(認知症加算)").toString()));
        //panel.getTxtNinteiIchijiHanteiYMD().setValue(new RDate(map.get("一次判定日").toString()));
        panel.getTxtNinteiIchijiHanteiYMD().setValue(ymlData.getAsRDate("一次判定日"));
        //panel.getTxtNinteiIchijiKanryoYMD().setValue(new RDate(map.get("一時判定完了日").toString()));
        panel.getTxtNinteiIchijiKanryoYMD().setValue(ymlData.getAsRDate("一次判定完了日"));
        //panel.getTxtNinteiNinteiYMD().setValue(new RDate(map.get("認定日").toString()));
        panel.getTxtNinteiNinteiYMD().setValue(ymlData.getAsRDate("認定日"));
        panel.getTxtNinteiJotaiKubun().setValue(new RString(map.get("状態区分").toString()));
        //panel.getTxtNinteiYukoKikan().setFromValue(new RDate(map.get("有効開始日").toString()));
        panel.getTxtNinteiYukoKikan().setFromValue(ymlData.getAsRDate("有効開始日"));
        //panel.getTxtNinteiYukoKikan().setToValue(new RDate(map.get("有効終了日").toString()));
        panel.getTxtNinteiYukoKikan().setToValue(ymlData.getAsRDate("有効終了日"));
        panel.getTxtNinteiIdoJiyu().setValue(new RString(map.get("異動事由").toString()));
        //panel.getTxtNinteiIdoYMD().setValue(new RDate(map.get("異動日").toString()));
        panel.getTxtNinteiIdoYMD().setValue(ymlData.getAsRDate("異動日"));
        //panel.getTxtNinteiSoshitsuYMD().setValue(new RDate(map.get("喪失日").toString()));
        panel.getTxtNinteiSoshitsuYMD().setValue(ymlData.getAsRDate("喪失日"));
        panel.getTxtNinteiTorikeshiRiyu().setValue(new RString(map.get("取消理由").toString()));
        //panel.getTxtNinteiTorikeshiYMD().setValue(new RDate(map.get("取消日").toString()));
        panel.getTxtNinteiTorikeshiYMD().setValue(ymlData.getAsRDate("取消日"));
        panel.getTxtNinteiTokuteiShippei().setValue(new RString(map.get("特定疾病").toString()));
    }

    // 受給：認定情報を作成する
    private dgSogoShokaiJukyuNinteiList_Row createJukyuNinteiListRow(
            String txtShinseiYMD,
            String txtShinseiKubun,
            String txtShinseiYukoKubun,
            String txtNinteiYMD,
            String txtJotaiKubun,
            String txtYukoKaishiYMD,
            String txtYukoShuryoYMD) {
        return new dgSogoShokaiJukyuNinteiList_Row(
                new ButtonDialog(),
                new RString(txtShinseiYMD),
                new RString(txtShinseiKubun),
                new RString(txtShinseiYukoKubun),
                new RString(txtNinteiYMD),
                new RString(txtJotaiKubun),
                new RString(txtYukoKaishiYMD),
                new RString(txtYukoShuryoYMD));
    }

    // 受給：減免・減額情報を設定する
    private void setJukyuGenmenGengakuInfo(tplSogoShokaiJukyuGenmenGengakuDiv panel) {
        List<HashMap> mapList = getYamlData(YML_GENMEN_GENGAKU);
        List<dgSogoShokaiJukyuGenmenGengakuList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createJukyuGenmenGengakuListRow(
                    map.get(適用開始日.toString()).toString(),
                    map.get("有効期限").toString(),
                    map.get(決定日.toString()).toString(),
                    map.get("決定区分").toString(),
                    map.get(申請日.toString()).toString(),
                    map.get("減免・減額種類").toString()));
        }
        panel.getDgSogoShokaiJukyuGenmenGengakuList().setDataSource(list);
    }

    // 受給：減免・減額詳細情報を設定する
    private void setJukyuGenmenGengakuDetailInfo(SogoShokaiGenmenGengakuInfoDiv panel) {
        HashMap map = getYamlData(YML_GENMEN_GENGAKU).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtGenmenShinseiYMD().setValue(new RDate(map.get(申請日.toString()).toString()));
        panel.getTxtGenmenShinseiYMD().setValue(ymlData.getAsRDate(申請日.toString()));
        panel.getTxtGenmenKyuSochiUmu().setValue(new RString(map.get("旧措置者有無").toString()));

        SogoShokaiGenmenGengakuTechoDiv techoDiv = panel.getSogoShokaiGenmenGengakuTecho();
        techoDiv.getTxtGenmenTechoUmu().setValue(new RString(map.get("手帳有無").toString()));
        techoDiv.getTxtGenmenTechoTokyu().setValue(new RString(map.get("等級").toString()));
        techoDiv.getTxtGenmenTechoNo().setValue(new RString(map.get("番号").toString()));
        //techoDiv.getTxtGenmenTechoKofuYMD().setValue(new RDate(map.get("交付日").toString()));
        techoDiv.getTxtGenmenTechoKofuYMD().setValue(ymlData.getAsRDate("交付日"));

        panel.getTxtGenmenSeihoUmu().setValue(new RString(map.get("生活保護受給有無").toString()));
        panel.getTxtGenmenSeihoTokureiUmu().setValue(new RString(map.get("特例措置対象者").toString()));
        panel.getTxtGenmenRofukuUmu().setValue(new RString(map.get("老齢福祉年金受給有無").toString()));
        panel.getTxtGenmenFutanDankai().setValue(new RString(map.get("利用者負担段階").toString()));
        panel.getTxtGenmenKyokaiKubun().setValue(new RString(map.get("境界層該当者区分").toString()));
        panel.getTxtGenmenGekihenDanwaKubun().setValue(new RString(map.get("激変緩和措置対象者区分").toString()));

        SogoShokaiGenmenGengakuFutanDiv futanDiv = panel.getSogoShokaiGenmenGengakuFutan();
        futanDiv.getTxtGenmenFutanKetteiKubun().setValue(new RString(map.get("決定区分").toString()));
        //futanDiv.getTxtGenmenFutanKetteiYMD().setValue(new RDate(map.get(決定日.toString()).toString()));
        futanDiv.getTxtGenmenFutanKetteiYMD().setValue(ymlData.getAsRDate(決定日.toString()));
        //futanDiv.getTxtGenmenFutanTekiyoKaishiYMD().setValue(new RDate(map.get(適用開始日.toString()).toString()));
        futanDiv.getTxtGenmenFutanTekiyoKaishiYMD().setValue(ymlData.getAsRDate(適用開始日.toString()));
        //futanDiv.getTxtGenmenFutanYukoKigen().setValue(new RDate(map.get("有効期限").toString()));
        futanDiv.getTxtGenmenFutanYukoKigen().setValue(ymlData.getAsRDate("有効期限"));
        futanDiv.getTxtGenmenFutanKyufuritsu().setValue(new Decimal(map.get("給付率").toString()));
        futanDiv.getTxtGenmenFutanFutanshaNo().setValue(new RString(map.get("公費負担者番号").toString()));
        futanDiv.getTxtGenmenFutanJukyushaNo().setValue(new RString(map.get("公費受給者番号").toString()));
        futanDiv.getTxtGenmenFutanKyoshitsuShubetsu().setValue(new RString(map.get("居室種別").toString()));
        futanDiv.getTxtGenmenFutanShokuji().setValue(new Decimal(map.get("食費負担限度額").toString()));
        futanDiv.getTxtGenmenFutanUnit().setValue(new Decimal(map.get("ユニット型個室").toString()));
        futanDiv.getTxtGenmenFutanUnitJun().setValue(new Decimal(map.get("ユニット型準個室").toString()));
        futanDiv.getTxtGenmenFutanTokuyo().setValue(new Decimal(map.get("従来型個室(特養等)").toString()));
        futanDiv.getTxtGenmenFutanRoken().setValue(new Decimal(map.get("従来型個室(老健・療養等)").toString()));
        futanDiv.getTxtGenmenFutanTasho().setValue(new Decimal(map.get("多床室").toString()));
        futanDiv.getTxtGenmenFutanSeigen().setValue(new RString(map.get("軽減対象サービスの制限").toString()));
        futanDiv.getTxtGenmenFutanGengakuKubun().setValue(new RString(map.get("減額区分").toString()));
        futanDiv.getTxtGenmenFutanFutangaku().setValue(new Decimal(map.get("負担額").toString()));

        panel.getTxtGenmenFutanHyojunKubun().setValue(new RString(map.get("標準負担区分").toString()));
    }

    // 受給：減免・減額情報を作成する
    private dgSogoShokaiJukyuGenmenGengakuList_Row createJukyuGenmenGengakuListRow(
            String txtTekiyoKaishiYMD,
            String txtYukoKigen,
            String txtKetteiYMD,
            String txtKetteiKubun,
            String txtShinseiYMD,
            String txtGenmenGengakuShurui) {
        return new dgSogoShokaiJukyuGenmenGengakuList_Row(
                new ButtonDialog(),
                new RString(txtTekiyoKaishiYMD),
                new RString(txtYukoKigen),
                new RString(txtKetteiYMD),
                new RString(txtKetteiKubun),
                new RString(txtShinseiYMD),
                new RString(txtGenmenGengakuShurui));
    }

    // 受給：施設入所情報を設定する
    private void setJukyuShisetsuNyushoInfo(tplSogoShokaiJukyuShisetsuNyushoDiv panel) {
        List<HashMap> mapList = getYamlData(YML_SHISETSU_NYUSHO);
        List<dgSogoShokaiJukyuShisetsuNyushoList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createJukyuShisetsuNyushoListRow(
                    map.get("施設分類").toString(),
                    map.get(入所日.toString()).toString(),
                    map.get(退所日.toString()).toString(),
                    map.get("施設名称").toString(),
                    map.get(事業者名称.toString()).toString(),
                    map.get("所在地").toString()
            ));
        }
        panel.getDgSogoShokaiJukyuShisetsuNyushoList().setDataSource(list);
    }

    // 受給：施設入所詳細情報を設定する
    private void setJukyuShisetsuNyushoDetailInfo(SogoShokaiShisetsuNyushoInfoDiv panel) {
        HashMap map = getYamlData(YML_SHISETSU_NYUSHO).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        panel.getTxtShisetsuBunrui().setValue(new RString(map.get("施設分類").toString()));
        //panel.getTxtShisetsuNyushoYMD().setValue(new RDate(map.get(入所日.toString()).toString()));
        panel.getTxtShisetsuNyushoYMD().setValue(ymlData.getAsRDate(入所日.toString()));
        //panel.getTxtShisetsuTaishoYMD().setValue(new RDate(map.get(退所日.toString()).toString()));
        panel.getTxtShisetsuTaishoYMD().setValue(ymlData.getAsRDate(退所日.toString()));
        panel.getTxtShisetsuName().setValue(new RString(map.get("施設名称").toString()));
        panel.getTxtShisetsuJigyoshaNo().setValue(new RString(map.get(事業者コード.toString()).toString()));
        panel.getTxtShisetsuJigyoshaName().setValue(new RString(map.get(事業者名称.toString()).toString()));
        panel.getTxtShisetsuJigyoshaJusho().setValue(new RString(map.get("所在地").toString()));
    }

    // 受給：施設入所情報を作成する
    private dgSogoShokaiJukyuShisetsuNyushoList_Row createJukyuShisetsuNyushoListRow(
            String txtBunrui,
            String txtNyushoYMD,
            String txtTaishoYMD,
            String txtShisetsuName,
            String txtJigyosha,
            String txtShozaichi) {
        return new dgSogoShokaiJukyuShisetsuNyushoList_Row(
                new ButtonDialog(),
                new RString(txtBunrui),
                new RString(txtNyushoYMD),
                new RString(txtTaishoYMD),
                new RString(txtShisetsuName),
                new RString(txtJigyosha),
                new RString(txtShozaichi));
    }

    // 受給：給付制限情報を設定する
    private void setJukyuKyufuSeigenInfo(tplSogoShokaiJukyuKyufuSeigenDiv panel) {
        List<HashMap> mapList = getYamlData(YML_KYUFU_SEIGEN);
        List<dgSogoShokaiJukyuKyufuSeigenList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createJukyuKyufuSeigenListRow(
                    map.get("登録状況").toString(),
                    map.get("変更決定日").toString(),
                    map.get("一時差止終了日").toString(),
                    map.get("変更適用終了日").toString(),
                    map.get("滞納控除決定日").toString(),
                    map.get("減額決定日").toString(),
                    map.get("減額適用開始日").toString()
            ));
        }
        panel.getDgSogoShokaiJukyuKyufuSeigenList().setDataSource(list);
    }

    // 受給：給付制限詳細情報を設定する
    private void setJukyuKyufuSeigenDetailInfo(SogoShokaiKyufuSeigenInfoDiv panel) {
        HashMap map = getYamlData(YML_KYUFU_SEIGEN).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        panel.getTxtSeigenTorokuJokyo().setValue(new RString(map.get("登録状況").toString()));
        panel.getTxtSeigenShuryoJokyo().setValue(new RString(map.get("終了状況").toString()));

        SogoShokaiKyufuSeigenHenkoDiv henkoDiv = panel.getSogoShokaiKyufuSeigenHenko();
        //henkoDiv.getTxtSeigenHenkoYokokuTorokuYMD().setValue(new RDate(map.get("予告登録日").toString()));
        henkoDiv.getTxtSeigenHenkoYokokuTorokuYMD().setValue(ymlData.getAsRDate("予告登録日"));
        //henkoDiv.getTxtSeigenHenkoKetteiYMD().setValue(new RDate(map.get("変更決定日").toString()));
        henkoDiv.getTxtSeigenHenkoKetteiYMD().setValue(ymlData.getAsRDate("変更決定日"));
        //henkoDiv.getTxtSeigenHenkoSashitomeSyuryoYMD().setValue(new RDate(map.get("一時差止終了日").toString()));
        henkoDiv.getTxtSeigenHenkoSashitomeSyuryoYMD().setValue(ymlData.getAsRDate("一時差止終了日"));
        //henkoDiv.getTxtSeigenHenkoTekiyoShuryoYMD().setValue(new RDate(map.get("変更適用終了日").toString()));
        henkoDiv.getTxtSeigenHenkoTekiyoShuryoYMD().setValue(ymlData.getAsRDate("変更適用終了日"));

        //panel.getTxtSeigenTainoKojoKetteiYMD().setValue(new RDate(map.get("滞納控除決定日").toString()));
        panel.getTxtSeigenTainoKojoKetteiYMD().setValue(ymlData.getAsRDate("滞納控除決定日"));
        //panel.getTxtSeigenChoshuShometsuKikan().setFromValue(new RDate(map.get("徴収権消滅開始日").toString()));
        panel.getTxtSeigenChoshuShometsuKikan().setFromValue(ymlData.getAsRDate("徴収権消滅開始日"));
        //panel.getTxtSeigenChoshuShometsuKikan().setToValue(new RDate(map.get("徴収権消滅終了日").toString()));
        panel.getTxtSeigenChoshuShometsuKikan().setToValue(ymlData.getAsRDate("徴収権消滅終了日"));
        //panel.getTxtSeigenNofuzumiKikan().setFromValue(new RDate(map.get("納付済開始日").toString()));
        panel.getTxtSeigenNofuzumiKikan().setFromValue(ymlData.getAsRDate("納付済開始日"));
        //panel.getTxtSeigenNofuzumiKikan().setToValue(new RDate(map.get("納付済終了日").toString()));
        panel.getTxtSeigenNofuzumiKikan().setToValue(ymlData.getAsRDate("納付済終了日"));

        SogoShokaiKyufuSeigenGengakuDiv gengakuDiv = panel.getSogoShokaiKyufuSeigenGengaku();
        //gengakuDiv.getTxtSeigenGengakuKikan().setFromValue(new RDate(map.get("減額開始日").toString()));
        gengakuDiv.getTxtSeigenGengakuKikan().setFromValue(ymlData.getAsRDate("減額開始日"));
        //gengakuDiv.getTxtSeigenGengakuKikan().setToValue(new RDate(map.get("減額終了日").toString()));
        gengakuDiv.getTxtSeigenGengakuKikan().setToValue(ymlData.getAsRDate("減額終了日"));
        //gengakuDiv.getTxtSeigenGengakuKetteiYMD().setValue(new RDate(map.get("減額決定日").toString()));
        gengakuDiv.getTxtSeigenGengakuKetteiYMD().setValue(ymlData.getAsRDate("減額決定日"));
        //gengakuDiv.getTxtSeigenGengakuTekiyoKikan().setFromValue(new RDate(map.get("減額適用開始日").toString()));
        gengakuDiv.getTxtSeigenGengakuTekiyoKikan().setFromValue(ymlData.getAsRDate("減額適用開始日"));
        //gengakuDiv.getTxtSeigenGengakuTekiyoKikan().setToValue(new RDate(map.get("減額適用終了日").toString()));
        gengakuDiv.getTxtSeigenGengakuTekiyoKikan().setToValue(ymlData.getAsRDate("減額適用終了日"));
    }

    // 受給：給付制限情報を作成する
    private dgSogoShokaiJukyuKyufuSeigenList_Row createJukyuKyufuSeigenListRow(
            String txtTorokuJokyo,
            String txtHenkoKetteiYMD,
            String txtSashidomeShuryoYMD,
            String txtHenkoShuryoYMD,
            String txtKojoKetteiYMD,
            String txtGengakuKetteiYMD,
            String txtGengakuKaishiYMD) {
        return new dgSogoShokaiJukyuKyufuSeigenList_Row(
                new ButtonDialog(),
                new RString(txtTorokuJokyo),
                new RString(txtHenkoKetteiYMD),
                new RString(txtSashidomeShuryoYMD),
                new RString(txtHenkoShuryoYMD),
                new RString(txtKojoKetteiYMD),
                new RString(txtGengakuKetteiYMD),
                new RString(txtGengakuKaishiYMD));
    }

    // 給付：居宅サービス計画情報を設定する
    private void setKyufuKyotakuServiceKeikakuInfo(tplSogoShokaiKyufuKyotakuServiceKeikakuDiv panel) {
        List<HashMap> mapList = getYamlData(YML_SERVICE_KEIKAKU);
        List<dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createKyufuKyotakuServiceKeikakuListRow(
                    map.get("届出日").toString(),
                    map.get(適用開始日.toString()).toString(),
                    map.get("適用終了日").toString(),
                    map.get("変更日").toString()
            ));
        }
        panel.getDgSogoShokaiKyufuKyotakuServiceKeikakuList().setDataSource(list);
    }

    // 給付：居宅サービス計画詳細情報を設定する
    private void setKyufuKyotakuServiceKeikakuDetailInfo(SogoShokaiKyotakuServiceKeikakuInfoDiv panel) {
        HashMap map = getYamlData(YML_SERVICE_KEIKAKU).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtKeikakuTodokedeYMD().setValue(new RDate(map.get("届出日").toString()));
        panel.getTxtKeikakuTodokedeYMD().setValue(ymlData.getAsRDate("届出日"));
        //panel.getTxtKeikakuHenkoYMD().setValue(new RDate(map.get("変更日").toString()));
        panel.getTxtKeikakuHenkoYMD().setValue(ymlData.getAsRDate("変更日"));
        panel.getTxtKeikakuJigyoshaShurui().setValue(new RString(map.get("事業者種類").toString()));
        panel.getTxtKeikakuJigyoshaNo().setValue(new RString(map.get(事業者コード.toString()).toString()));
        panel.getTxtKeikakuJigyoshaName().setValue(new RString(map.get(事業者名称.toString()).toString()));
        panel.getTxtKeikakuServiceShurui().setValue(new RString(map.get("サービス種類").toString()));
        panel.getTxtKeikakuSakuseiKubun().setValue(new RString(map.get("計画作成区分").toString()));
        //panel.getTxtKeikakuYM().setValue(new RDate(map.get("計画年月").toString()));
        panel.getTxtKeikakuYM().setValue(ymlData.getAsRDate("計画年月"));
        //panel.getTxtKeikakuKikan().setFromValue(new RDate(map.get(適用開始日.toString()).toString()));
        panel.getTxtKeikakuKikan().setFromValue(ymlData.getAsRDate(適用開始日.toString()));
        //panel.getTxtKeikakuKikan().setToValue(new RDate(map.get("適用終了日").toString()));
        panel.getTxtKeikakuKikan().setToValue(ymlData.getAsRDate("適用終了日"));
    }

    // 給付：居宅サービス計画情報を作成する
    private dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row createKyufuKyotakuServiceKeikakuListRow(
            String txtTodokedeYMD,
            String txtTekiyoKaishiYMD,
            String txtTekiyoShuryoYMD,
            String txtHenkoYMD) {
        return new dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row(
                new ButtonDialog(),
                new RString(txtTodokedeYMD),
                new RString(txtTekiyoKaishiYMD),
                new RString(txtTekiyoShuryoYMD),
                new RString(txtHenkoYMD));
    }

    // 給付：高額介護サービス情報を設定する
    private void setKyufuKogakuKaigoServiceInfo(tplSogoShokaiKyufuKogakuKaigoServiceDiv panel) {
        List<HashMap> mapList = getYamlData(YML_KOGAKU_SERVICE);
        List<dgSogoShokaiKyufuKogakuKaigoServiceList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createKyufuKogakuKaigoServiceListRow(
                    map.get(提供年月.toString()).toString(),
                    map.get(申請日.toString()).toString(),
                    map.get(決定日.toString()).toString()));
        }
        panel.getDgSogoShokaiKyufuKogakuKaigoServiceList().setDataSource(list);
    }

    // 給付：高額介護サービス詳細情報を設定する
    private void setKyufuKogakuKaigoServiceDetailInfo(SogoShokaiKogakuKaigoServicehiInfoDiv panel) {
        HashMap map = getYamlData(YML_KOGAKU_SERVICE).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtKogakuTeikyoYM().setValue(new RDate(map.get(提供年月.toString()).toString()));
        panel.getTxtKogakuTeikyoYM().setValue(ymlData.getAsRDate(提供年月.toString()));
        //panel.getTxtKogakuShinseiYMD().setValue(new RDate(map.get(申請日.toString()).toString()));
        panel.getTxtKogakuShinseiYMD().setValue(ymlData.getAsRDate(申請日.toString()));
        //panel.getTxtKogakuShiharaigaku().setValue(new Decimal(map.get("本人支払額").toString()));
        panel.getTxtKogakuShiharaigaku().setValue(ymlData.getAsDecimal("本人支払額"));
        panel.getTxtKogakuShiharaiHoho().setValue(new RString(map.get("支払方法").toString()));
        panel.getTxtKogakuKinyuKikanCode().setValue(new RString(map.get("金融機関コード").toString()));
        panel.getTxtKogakuKinyuKikanName().setValue(new RString(map.get("金融機関名").toString()));
        panel.getTxtKogakuShitenCode().setValue(new RString(map.get("支店コード").toString()));
        panel.getTxtKogakuShitenName().setValue(new RString(map.get("支店名").toString()));
        panel.getTxtKogakuKozaShubetsu().setValue(new RString(map.get("口座種別").toString()));
        panel.getTxtKogakuKozaNo().setValue(new RString(map.get("口座番号").toString()));
        panel.getTxtKogakuKozaMeiginin().setValue(new RString(map.get("名義人").toString()));
        panel.getTxtKogakuKozaMeigininKana().setValue(new RString(map.get("名義人カナ").toString()));
        //panel.getTxtKogakuKetteiYMD().setValue(new RDate(map.get(決定日.toString()).toString()));
        panel.getTxtKogakuKetteiYMD().setValue(ymlData.getAsRDate(決定日.toString()));
        panel.getTxtKogakuShikyuKubun().setValue(new RString(map.get("支給・不支給区分").toString()));
        //panel.getTxtKogakuShikyugaku().setValue(new Decimal(map.get("支給金額").toString()));
        panel.getTxtKogakuShikyugaku().setValue(ymlData.getAsDecimal("支給金額"));
        panel.getTxtKogakuFushikyuRiyu().setValue(new RString(map.get("不支給理由").toString()));
        panel.getTxtKogakuSetaiShuyakuNo().setValue(new RString(map.get("世帯集約番号").toString()));

        SogoShokaiKogakuKokuhorenKetteiDiv ketteiDiv = panel.getSogoShokaiKogakuKokuhorenKettei();
        ketteiDiv.getTxtKogakuKokuhorenTsuchishoNo().setValue(new RString(map.get("通知書番号").toString()));
        ketteiDiv.getTxtKogakuKokuhorenShikyuKubun().setValue(new RString(map.get("支給区分").toString()));
        //ketteiDiv.getTxtKogakuKokuhorenKetteiYM().setValue(new RDate(map.get("決定年月").toString()));
        ketteiDiv.getTxtKogakuKokuhorenKetteiYM().setValue(ymlData.getAsRDate("決定年月"));
        //ketteiDiv.getTxtKogakuKokuhorenFutangaku().setValue(new Decimal(map.get("利用者負担額").toString()));
        ketteiDiv.getTxtKogakuKokuhorenFutangaku().setValue(ymlData.getAsDecimal("利用者負担額"));
        //ketteiDiv.getTxtKogakuKokuhorenShikyugaku().setValue(new Decimal(map.get("高額支給額").toString()));
        ketteiDiv.getTxtKogakuKokuhorenShikyugaku().setValue(ymlData.getAsDecimal("高額支給額"));

        //panel.getTxtKogakuTsuchishoSakuseiYMD().setValue(new RDate(map.get("決定通知書作成日").toString()));
        panel.getTxtKogakuTsuchishoSakuseiYMD().setValue(ymlData.getAsRDate("決定通知書作成日"));

        SogoShokaiKogakuFurikomiDiv furikomiDiv = panel.getSogoShokaiKogakuFurikomi();
        //furikomiDiv.getTxtKogakuFurikomiMeisaiSakuseiYMD().setValue(new RDate(map.get("振込明細作成日").toString()));
        furikomiDiv.getTxtKogakuFurikomiMeisaiSakuseiYMD().setValue(ymlData.getAsRDate("振込明細作成日"));
        //furikomiDiv.getTxtKogakuFurikomiShiharaiYoteiYMD().setValue(new RDate(map.get("支払予定日").toString()));
        furikomiDiv.getTxtKogakuFurikomiShiharaiYoteiYMD().setValue(ymlData.getAsRDate("支払予定日"));

        SogoShokaiKogakuKokuhorenSofuDiv sofuDiv = panel.getSogoShokaiKogakuKokuhorenSofu();
        //sofuDiv.getTxtKogakuKokuhorenSofuYM().setValue(new RDate(map.get("送付年月").toString()));
        sofuDiv.getTxtKogakuKokuhorenSofuYM().setValue(ymlData.getAsRDate("送付年月"));
        //sofuDiv.getTxtKogakuKokuhorenUketoriYM().setValue(new RDate(map.get("決定受取年月").toString()));
        sofuDiv.getTxtKogakuKokuhorenUketoriYM().setValue(ymlData.getAsRDate("決定受取年月"));
    }

    // 給付：高額介護サービス情報を作成する
    private dgSogoShokaiKyufuKogakuKaigoServiceList_Row createKyufuKogakuKaigoServiceListRow(
            String txtTeikyoYM,
            String txtShinseiYMD,
            String txtKetteiYMD) {
        return new dgSogoShokaiKyufuKogakuKaigoServiceList_Row(
                new ButtonDialog(),
                new RString(txtTeikyoYM),
                new RString(txtShinseiYMD),
                new RString(txtKetteiYMD));
    }

    // 給付：償還払情報を設定する
    private void setKyufuShokanBaraiInfo(tplSogoShokaiKyufuShokanBaraiDiv panel) {
        List<HashMap> mapList = getYamlData(YML_SHOKAN_BARAI);
        List<dgSogoShokaiKyufuShokanBaraiList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createKyufuShokanBaraiListRow(
                    map.get(提供年月.toString()).toString(),
                    map.get("サービス種類").toString(),
                    map.get(申請日.toString()).toString(),
                    map.get("整理番号").toString(),
                    map.get("支払金額合計").toString(),
                    map.get("保険請求額合計").toString(),
                    map.get("自己負担額合計").toString()));
        }
        panel.getDgSogoShokaiKyufuShokanBaraiList().setDataSource(list);
    }

    // 給付：償還払情報を作成する
    private dgSogoShokaiKyufuShokanBaraiList_Row createKyufuShokanBaraiListRow(
            String txtServiceYM,
            String txtServiceShurui,
            String txtShinseiYMD,
            String txtSeiriNo,
            String txtShiharaiGokei,
            String txtHokenGokei,
            String txtJikoFutanGokei) {
        return new dgSogoShokaiKyufuShokanBaraiList_Row(
                new ButtonDialog(),
                new RString(txtServiceYM),
                new RString(txtServiceShurui),
                new RString(txtShinseiYMD),
                new RString(txtSeiriNo),
                new RString(txtShiharaiGokei),
                new RString(txtHokenGokei),
                new RString(txtJikoFutanGokei));
    }

    // 給付：福祉用具購入費詳細情報を設定する
    private void setFukushiYoguKonyuhiDetailInfo(SogoShokaiFukushiYoguKonyuhiInfoDiv panel, int meisaiIndex) {
        HashMap map = getYamlData(YML_YOGU_KONYUHI).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtTeikyoYM().setValue(new RDate(map.get(提供年月.toString()).toString()));
        panel.getTxtTeikyoYM().setValue(ymlData.getAsRDate(提供年月.toString()));
        panel.getTxtSeiriNo().setValue(new RString(map.get("整理番号").toString()));
        panel.getTxtKyufuritsu().setValue(new Decimal(map.get("給付率").toString()));

        tblYoguSeikyuSummaryDiv summaryDiv = panel.getTblYoguSeikyuSummary();
        //summaryDiv.getTxtYoguPayTotalMae().setValue(new Decimal(map.get("前回支払金額合計").toString()));
        summaryDiv.getTxtYoguPayTotalMae().setValue(ymlData.getAsDecimal("前回支払金額合計"));
        //summaryDiv.getTxtYoguHokenSeikyuAmountMae().setValue(new Decimal(map.get("前回保険請求額").toString()));
        summaryDiv.getTxtYoguHokenSeikyuAmountMae().setValue(ymlData.getAsDecimal("前回保険請求額"));
        //summaryDiv.getTxtYoguRiyoshaFutanAmountMae().setValue(new Decimal(map.get("前回利用者負担額").toString()));
        summaryDiv.getTxtYoguRiyoshaFutanAmountMae().setValue(ymlData.getAsDecimal("前回利用者負担額"));
        //summaryDiv.getTxtYoguLimitOverAmountMae().setValue(new Decimal(map.get("前回限度超過額").toString()));
        summaryDiv.getTxtYoguLimitOverAmountMae().setValue(ymlData.getAsDecimal("前回限度超過額"));
        //summaryDiv.getTxtYoguPayTotalNow().setValue(new Decimal(map.get("今回支払金額合計").toString()));
        summaryDiv.getTxtYoguPayTotalNow().setValue(ymlData.getAsDecimal("今回支払金額合計"));
        //summaryDiv.getTxtYoguHokenSeikyuAmountNow().setValue(new Decimal(map.get("今回保険請求額").toString()));
        summaryDiv.getTxtYoguHokenSeikyuAmountNow().setValue(ymlData.getAsDecimal("今回保険請求額"));
        //summaryDiv.getTxtYoguRiyoshaFutanAmountNow().setValue(new Decimal(map.get("今回利用者負担額").toString()));
        summaryDiv.getTxtYoguRiyoshaFutanAmountNow().setValue(ymlData.getAsDecimal("今回利用者負担額"));
        //summaryDiv.getTxtYoguLimitOverAmountNow().setValue(new Decimal(map.get("今回限度超過額").toString()));
        summaryDiv.getTxtYoguLimitOverAmountNow().setValue(ymlData.getAsDecimal("今回限度超過額"));

        NumberFormat nfNum = NumberFormat.getNumberInstance();
        List<HashMap> mapList = getYamlData(YML_YOGU_KONYUHI_MEISAI);
        List<dgYoguSeikyuDetail_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap meisaiMap = mapList.get(index);
            list.add(createYoguSeikyuDetailRow(
                    meisaiMap.get("購入日").toString(),
                    meisaiMap.get("種目").toString(),
                    meisaiMap.get("商品名").toString(),
                    nfNum.format(Integer.parseInt(meisaiMap.get("購入金額").toString())),
                    meisaiMap.get("審査方法").toString()
            ));
        }
        panel.getDgYoguSeikyuDetail().setDataSource(list);

        HashMap meisaiMap = mapList.get(meisaiIndex);
        ControlGenerator ymlData1 = new ControlGenerator(meisaiMap);
        YoguKonyuhiShikyuShinseiSeikyuDetailDiv detailDiv = panel.getYoguKonyuhiShikyuShinseiSeikyuDetail();
        //detailDiv.getTxtBuyYMD().setValue(new RDate(meisaiMap.get("購入日").toString()));
        detailDiv.getTxtBuyYMD().setValue(ymlData1.getAsRDate("購入日"));
        detailDiv.getTxtShumoku().setValue(new RString(meisaiMap.get("種目").toString()));
        detailDiv.getTxtShohinName().setValue(new RString(meisaiMap.get("商品名").toString()));
        detailDiv.getTxtSeizoJigyosha().setValue(new RString(meisaiMap.get("製造事業者").toString()));
        detailDiv.getTxtHanbaiJigyosha().setValue(new RString(meisaiMap.get("販売事業者").toString()));
        //detailDiv.getTxtBuyAmount().setValue(new Decimal(meisaiMap.get("購入金額").toString()));
        detailDiv.getTxtBuyAmount().setValue(ymlData1.getAsDecimal("購入金額"));
        detailDiv.getTxtHinmokuCode().setValue(new RString(meisaiMap.get("品目コード").toString()));
        detailDiv.getTxtShinsaMethod().setValue(new RString(meisaiMap.get("審査方法").toString()));
    }

    // 給付：福祉用具購入費明細情報を作成する
    private dgYoguSeikyuDetail_Row createYoguSeikyuDetailRow(
            String txtBuyYMD,
            String txtShumoku,
            String txtShohinName,
            String txtBuyAmount,
            String txtShinsaMethod) {
        return new dgYoguSeikyuDetail_Row(
                new Button(),
                new RString(txtBuyYMD),
                new RString(txtShumoku),
                new RString(txtShohinName),
                new RString(txtBuyAmount),
                new RString(txtShinsaMethod));
    }

    // 給付：過誤申立書情報を設定する
    private void setKyufuKagoMoushitateshoInfo(tplSogoShokaiKyufuKagoMoushitateshoDiv panel) {
        List<HashMap> mapList = getYamlData(YML_KAGO_MOUSHITATE);
        List<dgSogoShokaiKyufuKagoMoushitateshoList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createKyufuKagoMoushitateshoListRow(
                    map.get(申立日.toString()).toString(),
                    map.get(事業者名称.toString()).toString(),
                    map.get(サービス提供年月.toString()).toString(),
                    map.get("理由").toString()));
        }
        panel.getDgSogoShokaiKyufuKagoMoushitateshoList().setDataSource(list);
    }

    // 給付：過誤申立書明細情報を設定する
    private void setKyufuKagoMoushitateshoDetailInfo(SogoShokaiKagoMoushitateInfoDiv panel) {
        HashMap map = getYamlData(YML_KAGO_MOUSHITATE).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtKagoTaishoYM().setValue(new RDate(map.get("対象年月").toString()));
        panel.getTxtKagoTaishoYM().setValue(ymlData.getAsRDate("対象年月"));
        //panel.getTxtKagoMoshitateYMD().setValue(new RDate(map.get(申立日.toString()).toString()));
        panel.getTxtKagoMoshitateYMD().setValue(ymlData.getAsRDate(申立日.toString()));
        //panel.getTxtKagoTeikyoYM().setValue(new RDate(map.get(サービス提供年月.toString()).toString()));
        panel.getTxtKagoTeikyoYM().setValue(ymlData.getAsRDate(サービス提供年月.toString()));
        panel.getTxtKagoDogetsuKago().setValue(new RString(map.get("同月過誤").toString()));
        panel.getTxtKagoJigyoshaCode().setValue(new RString(map.get(事業者コード.toString()).toString()));
        panel.getTxtKagoJigyoshaName().setValue(new RString(map.get(事業者名称.toString()).toString()));

        SogoShokaiKagoMoshitateJiyuDiv jiyuDiv = panel.getSogoShokaiKagoMoshitateJiyu();
        jiyuDiv.getTxtKagoMoshitateYoshiki().setValue(new RString(map.get("様式").toString()));
        jiyuDiv.getTxtKagoMoshitateRiyu().setValue(new RString(map.get("理由").toString()));

        SogoShokaiKagoMoshitateHokenshaDiv hokenshaDiv = panel.getSogoShokaiKagoMoshitateKekka().getSogoShokaiKagoMoshitateHokensha();
        //hokenshaDiv.getTxtKagoHokenshaTanisu().setValue(new Decimal(map.get("保険者単位数").toString()));
        hokenshaDiv.getTxtKagoHokenshaTanisu().setValue(ymlData.getAsDecimal("保険者単位数"));
        //hokenshaDiv.getTxtKagoHokenshaFutangaku().setValue(new Decimal(map.get("保険者負担額").toString()));
        hokenshaDiv.getTxtKagoHokenshaFutangaku().setValue(ymlData.getAsDecimal("保険者負担額"));

        SogoShokaiKagoMoshitateKohiDiv kohiDiv = panel.getSogoShokaiKagoMoshitateKekka().getSogoShokaiKagoMoshitateKohi();
        kohiDiv.getTxtKagoKohiJukyushaNo().setValue(new RString(map.get("公費受給者番号").toString()));
        kohiDiv.getTxtKagoKohiJukyushaName().setValue(new RString(map.get("公費受給者氏名").toString()));
        kohiDiv.getTxtKagoKohiHokenshaNo().setValue(new RString(map.get("証記載保険者番号").toString()));
        //kohiDiv.getTxtKagoKohiTanisu().setValue(new Decimal(map.get("公費単位数").toString()));
        kohiDiv.getTxtKagoKohiTanisu().setValue(ymlData.getAsDecimal("公費単位数"));
        //kohiDiv.getTxtKagoKohiFutangaku().setValue(new Decimal(map.get("公費負担額").toString()));
        kohiDiv.getTxtKagoKohiFutangaku().setValue(ymlData.getAsDecimal("公費負担額"));
    }

    // 給付：過誤申立書情報を作成する
    private dgSogoShokaiKyufuKagoMoushitateshoList_Row createKyufuKagoMoushitateshoListRow(
            String txtMoushitateYMD,
            String txtJigyosha,
            String txtTeikyoYM,
            String txtRiyu) {
        return new dgSogoShokaiKyufuKagoMoushitateshoList_Row(
                new ButtonDialog(),
                new RString(txtMoushitateYMD),
                new RString(txtJigyosha),
                new RString(txtTeikyoYM),
                new RString(txtRiyu));
    }

    // 給付：再審査申立書情報を設定する
    private void setKyufuSaishinsaMoushitateshoInfo(tplSogoShokaiKyufuSaishinsaMoushitateshoDiv panel) {
        List<HashMap> mapList = getYamlData(YML_SAISHIN_MOUSHITATE);
        List<dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createKyufuSaishinsaMoushitateshoListRow(
                    map.get(申立日.toString()).toString(),
                    map.get(事業者名称.toString()).toString(),
                    map.get(サービス提供年月.toString()).toString(),
                    map.get("サービス名称").toString(),
                    map.get("申立単位数").toString(),
                    map.get("理由").toString()
            ));
        }
        panel.getDgSogoShokaiKyufuSaishinsaMoushitateshoList().setDataSource(list);
    }

    // 給付：再審査申立書詳細情報を設定する
    private void setKyufuSaishinsaMoushitateshoDetailInfo(SogoShokaiSaishinsaMoushitateInfoDiv panel) {
        HashMap map = getYamlData(YML_SAISHIN_MOUSHITATE).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtSaishinsaTaishoYM().setValue(new RDate(map.get("対象年月").toString()));
        panel.getTxtSaishinsaTaishoYM().setValue(ymlData.getAsRDate("対象年月"));
        //panel.getTxtSaishinsaMoshitateYMD().setValue(new RDate(map.get(申立日.toString()).toString()));
        panel.getTxtSaishinsaMoshitateYMD().setValue(ymlData.getAsRDate(申立日.toString()));
        //panel.getTxtSaishinsaTeikyoYM().setValue(new RDate(map.get(サービス提供年月.toString()).toString()));
        panel.getTxtSaishinsaTeikyoYM().setValue(ymlData.getAsRDate(サービス提供年月.toString()));
        panel.getTxtSaishinsaJigyoshaCode().setValue(new RString(map.get(事業者コード.toString()).toString()));
        panel.getTxtSaishinsaJigyoshaName().setValue(new RString(map.get(事業者名称.toString()).toString()));
        panel.getTxtSaishinsaServiceShuruiCode().setValue(new RString(map.get("サービス種類コード").toString()));
        panel.getTxtSaishinsaServiceCode().setValue(new RString(map.get("サービスコード").toString()));
        panel.getTxtSaishinsaServiceName().setValue(new RString(map.get("サービス名称").toString()));
        //panel.getTxtSaishinsaMoshitateTanisu().setValue(new Decimal(map.get("申立単位数").toString()));
        panel.getTxtSaishinsaMoshitateTanisu().setValue(ymlData.getAsDecimal("申立単位数"));

        SogoShokaiSaishinsaJiyuDiv jiyuDiv = panel.getSogoShokaiSaishinsaJiyu();
        jiyuDiv.getTxtSaishinsaMoshitateKomoku().setValue(new RString(map.get("項目").toString()));
        jiyuDiv.getTxtSaishinsaMoshitateRiyu().setValue(new RString(map.get("理由").toString()));

        SogoShokaiSaishinsaHokenshaDiv hokenshaDiv = panel.getSogoShokaiSaishinsaKekka().getSogoShokaiSaishinsaHokensha();
        hokenshaDiv.getTxtSaishinsaHokenshaKekka().setValue(new RString(map.get("保険者再審査結果").toString()));
        hokenshaDiv.getTxtSaishinsaHokenshaToshoTanisu().setValue(new Decimal(map.get("保険者当初請求単位数").toString()));
        hokenshaDiv.getTxtSaishinsaHokenshaGenshinTanisu().setValue(new Decimal(map.get("保険者原審単位数").toString()));
        hokenshaDiv.getTxtSaishinsaHokenshaMoshitateTanisu().setValue(new Decimal(map.get("保険者申立単位数").toString()));
        hokenshaDiv.getTxtSaishinsaHokenshaKetteiTanisu().setValue(new Decimal(map.get("保険者決定単位数").toString()));
        hokenshaDiv.getTxtSaishinsaHokenshaChoseiTanisu().setValue(new Decimal(map.get("保険者調整単位数").toString()));
        hokenshaDiv.getTxtSaishinsaHokenshaFutangaku().setValue(new Decimal(map.get("保険者負担額").toString()));

        SogoShokaiSaishinsaKohiDiv kohiDiv = panel.getSogoShokaiSaishinsaKekka().getSogoShokaiSaishinsaKohi();
        kohiDiv.getTxtSaishinsaKohiJukyushaNo().setValue(new RString(map.get("公費受給者番号").toString()));
        kohiDiv.getTxtSaishinsaKohiJukyushaName().setValue(new RString(map.get("公費受給者氏名").toString()));
        kohiDiv.getTxtSaishinsaKohiHokenshaNo().setValue(new RString(map.get("証記載保険者番号").toString()));
        kohiDiv.getTxtSaishinsaKohiKekka().setValue(new RString(map.get("公費再審査結果").toString()));
        kohiDiv.getTxtSaishinsaKohiToshoTanisu().setValue(new Decimal(map.get("公費当初請求単位数").toString()));
        kohiDiv.getTxtSaishinsaKohiGenshinTanisu().setValue(new Decimal(map.get("公費原審単位数").toString()));
        kohiDiv.getTxtSaishinsaKohiMoshitateTanisu().setValue(new Decimal(map.get("公費申立単位数").toString()));
        kohiDiv.getTxtSaishinsaKohiKetteiTanisu().setValue(new Decimal(map.get("公費決定単位数").toString()));
        kohiDiv.getTxtSaishinsaKohiChoseiTanisu().setValue(new Decimal(map.get("公費調整単位数").toString()));
        kohiDiv.getTxtSaishinsaKohiFutangaku().setValue(new Decimal(map.get("公費負担額").toString()));
    }

    // 給付：再審査申立書情報を作成する
    private dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row createKyufuSaishinsaMoushitateshoListRow(
            String txtMoushitateYMD,
            String txtJigyosha,
            String txtTeikyoYM,
            String txtService,
            String txtTanisu,
            String txtRiyu) {
        return new dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row(
                new ButtonDialog(),
                new RString(txtMoushitateYMD),
                new RString(txtJigyosha),
                new RString(txtTeikyoYM),
                new RString(txtService),
                new RString(txtTanisu),
                new RString(txtRiyu));
    }

    // 賦課情報を設定する
    private void setFukaInfo(SogoShokaiFukaDiv panel) {
        List<HashMap> mapList = getYamlData(YML_FUKA);
        List<dgSogoShokaiFukaList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createFukaListRow(
                    map.get("調定年度").toString(),
                    map.get("賦課年度").toString(),
                    map.get("更正月").toString(),
                    map.get("調定事由").toString()));
        }
        panel.getDgSogoShokaiFukaList().setDataSource(list);
    }

    // 賦課詳細情報を設定する
    private void setFukaDetailInfo(SogoShokaiFukaInfoDiv panel) {
        HashMap map = getYamlData(YML_FUKA).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        //panel.getTxtFukaChoteiNendo().setValue(new RDate(map.get("調定年度").toString()));
        panel.getTxtFukaChoteiNendo().setValue(ymlData.getAsRDate("調定年度"));
        panel.getTxtFukaChoteiJiyu().setValue(new RString(map.get("調定事由").toString()));
        //panel.getTxtFukaFukaNendo().setValue(new RDate(map.get("賦課年度").toString()));
        panel.getTxtFukaFukaNendo().setValue(ymlData.getAsRDate("賦課年度"));
        panel.getTxtFukaKazeiKubunHonnin().setValue(new RString(map.get("市町村民税課税区分(本人)").toString()));
        panel.getTxtFukaKazeiKubunSetai().setValue(new RString(map.get("市町村民税課税区分(世帯)").toString()));
        panel.getTxtFukaKoseiTsuki().setValue(new Decimal(map.get("更正月").toString()));

        tblFukaDiv fukaDiv = panel.getTblFuka();
        //fukaDiv.getTxtFukaKijunYMD().setValue(new RDate(map.get("賦課基準日").toString()));
        fukaDiv.getTxtFukaKijunYMD().setValue(ymlData.getAsRDate("賦課基準日"));
        fukaDiv.getTxtShotokuDankai().setValue(new RString(map.get("所得段階").toString()));
        fukaDiv.getTxtHokenryoRitsu().setValue(new Decimal(map.get("保険料率").toString()));
        fukaDiv.getTxtNenHokenryo().setValue(new Decimal(map.get("年額保険料").toString()));
        fukaDiv.getTxtTokubetsuSaishugaku().setValue(new Decimal(map.get("最終期保険料額(特)").toString()));
        fukaDiv.getTxtFutsuSaishugaku().setValue(new Decimal(map.get("最終期保険料額(普)").toString()));
        fukaDiv.getTxtGenmengaku().setValue(new Decimal(map.get("減免額").toString()));
        fukaDiv.getTxtZanteiGokei().setValue(new Decimal(map.get("暫定保険料額合計").toString()));
        fukaDiv.getTxtSudeniNofugaku().setValue(new Decimal(map.get("既に納付すべき額").toString()));
        fukaDiv.getTxtKongoNofugaku().setValue(new Decimal(map.get("今後納付すべき額").toString()));
        fukaDiv.getTxtNofuzumigaku().setValue(new Decimal(map.get("未到来期の納付済額").toString()));

        tblFutsuChoshuDiv futsuDiv = panel.getTblFutsuChoshu();
        futsuDiv.getTxtFutsu1().setValue(new Decimal(map.get("普徴１期").toString()));
        futsuDiv.getTxtFutsu2().setValue(new Decimal(map.get("普徴２期").toString()));
        futsuDiv.getTxtFutsu3().setValue(new Decimal(map.get("普徴３期").toString()));
        futsuDiv.getTxtFutsu4().setValue(new Decimal(map.get("普徴４期").toString()));
        futsuDiv.getTxtFutsu5().setValue(new Decimal(map.get("普徴５期").toString()));
        futsuDiv.getTxtFutsu6().setValue(new Decimal(map.get("普徴６期").toString()));
        futsuDiv.getTxtFutsu7().setValue(new Decimal(map.get("普徴７期").toString()));
        futsuDiv.getTxtFutsu8().setValue(new Decimal(map.get("普徴８期").toString()));
        futsuDiv.getTxtFutsu9().setValue(new Decimal(map.get("普徴９期").toString()));
        futsuDiv.getTxtFutsu10().setValue(new Decimal(map.get("普徴１０期").toString()));
        futsuDiv.getTxtFutsu11().setValue(new Decimal(map.get("普徴１１期").toString()));
        futsuDiv.getTxtFutsu12().setValue(new Decimal(map.get("普徴１２期").toString()));
        futsuDiv.getTxtFutsu13().setValue(new Decimal(map.get("普徴１３期").toString()));
        futsuDiv.getTxtFutsu14().setValue(new Decimal(map.get("普徴１４期").toString()));

        tblTokubetsuChoshuDiv tokubetsuDiv = panel.getTblTokubetsuChoshu();
        tokubetsuDiv.getTxtTokubetsu1().setValue(new Decimal(map.get("特徴１期").toString()));
        tokubetsuDiv.getTxtTokubetsu2().setValue(new Decimal(map.get("特徴２期").toString()));
        tokubetsuDiv.getTxtTokubetsu3().setValue(new Decimal(map.get("特徴３期").toString()));
        tokubetsuDiv.getTxtTokubetsu4().setValue(new Decimal(map.get("特徴４期").toString()));
        tokubetsuDiv.getTxtTokubetsu5().setValue(new Decimal(map.get("特徴５期").toString()));
        tokubetsuDiv.getTxtTokubetsu6().setValue(new Decimal(map.get("特徴６期").toString()));

        SogoShokaiFukaTokubetsuChoshuDiv choshuDiv = panel.getSogoShokaiFukaTokubetsuChoshu();
        choshuDiv.getTxtFukaTokubetsuChoshuNenkin().setValue(new RString(map.get("対象年金").toString()));
        choshuDiv.getTxtFukaTokubetsuChoshuGimusha().setValue(new RString(map.get("義務者").toString()));
    }

    // 賦課情報を作成する
    private dgSogoShokaiFukaList_Row createFukaListRow(
            String txtChoteiNendo,
            String txtFukaNendo,
            String txtKoseiTsuki,
            String txtRiyu) {
        return new dgSogoShokaiFukaList_Row(
                new ButtonDialog(),
                new RString(txtChoteiNendo),
                new RString(txtFukaNendo),
                new RString(txtKoseiTsuki),
                new RString(txtRiyu));
    }

    // 住民：境界層管理情報を設定する
    private void setJuminKyokaiKanriInfo(SogoShokaiJuminKyokaiKanriDiv panel) {
        List<HashMap> mapList = getYamlData(YML_KYOKAISO_KANRI);
        List<dgSogoShokaiJuminKyokaiKanriList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createJuminKyokaiKanriListRow(
                    map.get(適用開始日.toString()).toString(),
                    map.get("適用終了日").toString(),
                    map.get("給付額減額記載解除").toString(),
                    map.get("居住費軽減後居室種類").toString(),
                    map.get("居住費軽減後負担額").toString(),
                    map.get("食費軽減後負担額").toString(),
                    map.get("読替後高額介護世帯上限額").toString(),
                    map.get("保険料低減後所得段階").toString(),
                    map.get(決定日.toString()).toString()
            ));
        }
        panel.getDgSogoShokaiJuminKyokaiKanriList().setDataSource(list);
    }

    // 住民：総合事業対象者情報を設定する
    private void setJuminSogoJigyoInfo(SogoShokaiJuminSogoJigyoDiv panel) {
        HashMap map = getYamlData(YML_SOGO_JIGYO_TAISHOSHA).get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
//        panel.getTxtJigyoNijiKikan().setFromValue(new RDate(map.get("二次予防有効開始日").toString()));
//        panel.getTxtJigyoNijiKikan().setToValue(new RDate(map.get("二次予防有効終了日").toString()));
//        panel.getTxtJigyoNijiYoboHanteiYMD().setValue(new RDate(map.get("二次予防判定日").toString()));
        panel.getTxtJigyoNijiKikan().setFromValue(ymlData.getAsRDate("二次予防有効開始日"));
        panel.getTxtJigyoNijiKikan().setToValue(ymlData.getAsRDate("二次予防有効終了日"));
        panel.getTxtJigyoNijiYoboHanteiYMD().setValue(ymlData.getAsRDate("二次予防判定日"));
    }

    // 住民：境界層管理情報を作成する
    private dgSogoShokaiJuminKyokaiKanriList_Row createJuminKyokaiKanriListRow(
            String txtTekiyoKaishiYMD,
            String txtTekiyoShuryoYMD,
            String txtKisaiKaijo,
            String txtKyoshitsuShurui,
            String txtKyojuFutangaku,
            String txtShokuhiFutangaku,
            String txtSetaiJogengaku,
            String txtShotokuDankai,
            String txtKetteiYMD) {
        return new dgSogoShokaiJuminKyokaiKanriList_Row(
                new RString(txtTekiyoKaishiYMD),
                new RString(txtTekiyoShuryoYMD),
                new RString(txtKisaiKaijo),
                new RString(txtKyoshitsuShurui),
                new RString(txtKyojuFutangaku),
                new RString(txtShokuhiFutangaku),
                new RString(txtSetaiJogengaku),
                new RString(txtShotokuDankai),
                new RString(txtKetteiYMD));
    }
}
