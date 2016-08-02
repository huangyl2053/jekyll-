/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokubetuchosyutaisyosyatoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetuchosyutaisyosyatoroku.TokubetuChosyutaisyosyaTorokusqlparamEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 *
 * 特別徴収対象者登録のMapperクラスです。
 *
 * @reamsid_L DBB-0670-020 wangjie2
 */
public interface ITokubetuChosyutaisyosyaTorokuMapper {

    /**
     * 徴収方法情報取得。
     *
     * @param sqlparamEntity バラメンタ
     * @return 徴収方法の情報
     */
    DbT2001ChoshuHohoEntity getChoshuHoho(TokubetuChosyutaisyosyaTorokusqlparamEntity sqlparamEntity);

    /**
     * 年度内処理済み連番取得。
     *
     * @param sqlparamEntity バラメンタ
     * @return 処理日付管理マスタリスト
     */
    List<DbT7022ShoriDateKanriEntity> getShorizumiRenban(TokubetuChosyutaisyosyaTorokusqlparamEntity sqlparamEntity);

    /**
     * 資格喪失フラグ取得
     *
     * @param sqlparamEntity バラメンタ
     * @return 被保険者台帳管理
     */
    DbT1001HihokenshaDaichoEntity getHihokenshaFlag(TokubetuChosyutaisyosyaTorokusqlparamEntity sqlparamEntity);

    /**
     * 依頼金額計算基準日取得
     *
     * @param sqlparamEntity バラメンタ
     * @return 処理日付管理マスタ
     */
    List<DbT7022ShoriDateKanriEntity> getIraikinKijunbi(TokubetuChosyutaisyosyaTorokusqlparamEntity sqlparamEntity);
}
