/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atenasealcreate.AtenaSealCreateShutsuMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateDBZ100001Entity;

/**
 * 宛名シール作成のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public interface IAtenaSealCreateDBZ100001Mapper {

    /**
     * 年齢到達予定者選択した帳票を作成、データを取得します。
     *
     * @param param param
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getEntityList(AtenaSealCreateShutsuMybatisParameter param);

    /**
     * 抽出対象者が資格取得者帳票を作成、データを取得します。
     *
     * @param param param
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getEntityListTwo(AtenaSealCreateShutsuMybatisParameter param);

    /**
     * 宛名識別対象一時テーブル4帳票出力
     *
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getEntityListFour();

    /**
     * 宛名識別対象一時テーブル5帳票出力
     *
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getChuuShutsuTaishouSha5List();

    /**
     * 宛名識別対象一時テーブル6帳票出力
     *
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getChuuShutsuTaishouSha6List();
}
