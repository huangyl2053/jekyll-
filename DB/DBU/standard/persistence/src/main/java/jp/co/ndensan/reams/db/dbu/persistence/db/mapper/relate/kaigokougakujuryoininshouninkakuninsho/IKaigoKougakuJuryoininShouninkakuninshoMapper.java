/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigokougakujuryoininshouninkakuninsho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigokougakujuryoininshouninkakuninsho.KaigoKougakuJuryoininShouninkakuninshoParameter;

/**
 * [総合窓口用被保険者、受給者等判断]のマッパーインタフェースです。
 *
 * @reamsid_L DBU-4220-010 jinjue
 */
public interface IKaigoKougakuJuryoininShouninkakuninshoMapper {

    /**
     * 受給者情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 受給者情報
     */
    int select受給者(KaigoKougakuJuryoininShouninkakuninshoParameter 識別コード);

    /**
     * 被保険者情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 被保険者情報
     */
    int select被保険者(KaigoKougakuJuryoininShouninkakuninshoParameter 識別コード);
}
