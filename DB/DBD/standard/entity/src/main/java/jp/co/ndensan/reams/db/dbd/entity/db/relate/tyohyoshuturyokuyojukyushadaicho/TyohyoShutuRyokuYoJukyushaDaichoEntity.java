/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import java.util.List;

/**
 * 帳票出力用受給者台帳Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TyohyoShutuRyokuYoJukyushaDaichoEntity {

    private List<YokaigoNinteiJohoEntity> 要介護認定情報EntityList;
    private List<FutanGendogakuNinteiJohoEntity> 負担限度額認定情報EntityList;
    private List<ShafuHojinKeigenJohoEntity> 社福法人軽減情報EntityList;
    private List<RiyoshaFutanGenmenJohoEntity> 利用者負担減免情報EntityList;
    private List<HomonKaigoGenmenJohoEntity> 訪問介護等減額情報EntityList;
    private List<HyojunFutanGengakuJohoEntity> 標準負担減額情報EntityList;
    private List<TokubetsuChiikiKasanGenmenJohoEntity> 特別地域加算減免情報EntityList;
    private List<ShisetsuNyutaishojohoEntity> 施設入退所情報EntityList;
    private List<ItakuKeikakuTodokedejohoEntity> 居宅計画届出情報EntityList;
    private List<TokureiShisetuNyutaishojohoEntity> 特例施設入退所情報EntityList;
    private List<ShiharaHohoHenkojohoEntity> 支払方法変更情報EntityList;
    private List<KyufugakuGengakujohoEntity> 給付額減額情報EntityList;
    private List<ShikakujohoEntity> 資格情報EntityList;
    private List<RoreiFukushiNenkinjohoEntity> 老齢福祉年金情報EntityList;
    private List<SeikatsuHogojohoEntity> 生活保護情報EntityList;
}
