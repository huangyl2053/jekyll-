/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei.TaishoShaHanteiYoukonkyoItokiTempTableEntity;

/**
 * 承認処理Entityです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoninShoriEntity {

    private DbT4018KaigoHokenFutanGendogakuNinteiEntity 介護保険負担限度額認定Entity;
    private TaishoShaHanteiYoukonkyoItokiTempTableEntity 減免減額対象者判定用根拠一時Entity;

}
