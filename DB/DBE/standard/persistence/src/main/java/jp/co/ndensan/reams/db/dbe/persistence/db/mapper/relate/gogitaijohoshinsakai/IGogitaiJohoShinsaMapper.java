/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyotei.GogitaiIchiranJohoMapperParameter;

/**
 *
 * 合議体情報と開催予定情報の取得処理クラスです。
 *
 * @reamsid_L DBE-0130-040 yaodongsheng
 */
public interface IGogitaiJohoShinsaMapper {

    /**
     * 合議体情報の取得処理です。
     *
     * @param param 合議体一覧情報表示用パラメータ
     * @return 合議体情報 List<GogitaiJohoShinsaRelateEntity>
     */
    List<GogitaiJohoShinsaRelateEntity> get合議体情報(GogitaiIchiranJohoMapperParameter param);

    /**
     * 開催予定情報の取得処理です。
     *
     * @param コピー日 コピー日
     * @return 開催予定情報 List<ShinsakaiKaisaiYoteiJohoEntity>
     */
    List<ShinsakaiKaisaiYoteiJohoEntity> get開催予定情報(RString コピー日);
}
