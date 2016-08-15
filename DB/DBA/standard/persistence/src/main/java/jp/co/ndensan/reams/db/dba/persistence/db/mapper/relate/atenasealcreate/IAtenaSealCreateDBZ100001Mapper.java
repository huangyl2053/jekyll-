/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate;

import java.util.List;
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
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getEntityList();

    /**
     * 抽出対象者が資格取得者帳票を作成、データを取得します。
     *
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getEntityListTwo();

    /**
     * 抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除く帳票を作成、データを取得します。
     *
     * @return List<AtenaSealCreateDBZ100001Entity>
     */
    List<AtenaSealCreateDBZ100001Entity> getEntityListFour();
}
