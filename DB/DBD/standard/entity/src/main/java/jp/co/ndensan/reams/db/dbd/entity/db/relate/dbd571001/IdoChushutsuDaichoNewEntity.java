/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoChushutsuDaichoNewEntity {

    private NinteiKekkaJohoEntity 要介護認定情報;
    private FutanGendogakuNinteiEntity 負担限度額認定情報List;
    private HihokenshaDaichoEntity 資格情報List;
    private HomonKaigoRiyoshaFutangakuGengakuEntity 訪問介護等減額情報List;
    private HyojunFutangakuGemmenEntity 標準負担減額List;
    private KaigoJogaiTokureiTaishoShisetsuEntity 特例施設入退所List;
    private KyotakuKeikakuTodokedeEntity 居宅計画届出List;
    private RiyoshaFutangakuGengakuEntity 利用者負担減免List;
    private RoreiFukushiNenkinJukyushaEntity 老齢福祉年金List;
    private SeikatsuHogoJukyushaEntity 生活保護情報List;
    private ShakaiFukushiHojinRiyoshaFutanKeigenEntity 社福法人軽減List;
    private ShiharaiHohoHenkoEntity 支払方法変更List;
    private ShiharaiHohoHenkoGengakuEntity 給付額減額情報List;
    private ShisetsuNyutaishoEntity 施設入退所List;
    private TokubetsuchiikiKasanGemmenEntity 特別地域加算List;

}
