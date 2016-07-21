/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshosakuseiirai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.ninteishinseijoho.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.IkenshoirairirekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudouEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.ShujiiIkenshoTeishutsuIraishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼(手動)のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public interface IIkenshoSakuseiIraiMapper {

    /**
     * 主治医意見書作成依頼(手動)情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼(手動)情報リスト
     */
    IkenshoirairirekiichiranShudouEntity get主治医意見書作成依頼(RString 申請書管理番号);

    /**
     * 介護認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 介護認定申請情報
     */
    NinteiShinseiJohoEntity get要介護認定申請情報(RString 申請書管理番号);

    /**
     * 主治医意見書作成依頼発行一覧表情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼発行一覧表情報
     */
    List<IkenshoirairirekiichiranShudouEntity> get主治医意見書作成依頼発行一覧表(RString 申請書管理番号);

    /**
     * 主治医意見書依頼該当者履歴一覧情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 主治医意見書依頼該当者履歴一覧情報
     */
    List<IkenshoirairirekiIchiranEntity> get主治医意見書依頼該当者履歴一覧(RString 被保険者番号);

    /**
     * 介護保険指定医依頼兼主治医意見書提出意見書情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 介護保険指定医依頼兼主治医意見書提出意見書情報
     */
    List<ShujiiIkenshoTeishutsuIraishoEntity> get介護保険指定医依頼兼主治医意見書提出意見書(RString 申請書管理番号);

}
