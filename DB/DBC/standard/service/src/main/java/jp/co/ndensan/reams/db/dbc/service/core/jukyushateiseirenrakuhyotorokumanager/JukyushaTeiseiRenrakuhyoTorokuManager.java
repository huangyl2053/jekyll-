/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotorokumanager;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManagerResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（画面）
 *
 * @reamsid_L DBC-2101-030 quxiaodong
 */
public class JukyushaTeiseiRenrakuhyoTorokuManager {

    private final DbT3001JukyushaIdoRenrakuhyoDac 受給者異動送付Dac;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");

    /**
     * コンストラクタです。
     */
    public JukyushaTeiseiRenrakuhyoTorokuManager() {
        this.受給者異動送付Dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukyushaTeiseiRenrakuhyoTorokuManager}のインスタンス
     */
    public static JukyushaTeiseiRenrakuhyoTorokuManager createInstance() {
        return InstanceProvider.create(JukyushaTeiseiRenrakuhyoTorokuManager.class);
    }

    /**
     * 受給者訂正情報を受給者異動送付テーブルへ登録する。
     *
     * @param 履歴番号 int
     * @param 論理削除フラグ boolean
     * @param 受給者訂正連絡票登録画面Div JukyushaIdoRenrakuhyo
     * @return int 登録件数
     */
    @Transaction
    public JukyushaTeiseiRenrakuhyoTorokuManagerResult regJukyushaTeiseiJoho(
            int 履歴番号,
            boolean 論理削除フラグ,
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div) {
        JukyushaTeiseiRenrakuhyoTorokuManagerResult result = new JukyushaTeiseiRenrakuhyoTorokuManagerResult();
        result.set登録件数(0);
        int 件数 = 受給者異動送付Dac.selectCountByKey(
                受給者訂正連絡票登録画面Div.get被保険者番号(),
                受給者訂正連絡票登録画面Div.get異動年月日(), 履歴番号, 論理削除フラグ);
        if (0 == 件数) {
            result.set登録件数(1);
            result.setメッセージコード(new RString(UrErrorMessages.対象データなし.getMessage().getCode()));
        } else {
            DbT3001JukyushaIdoRenrakuhyoEntity 受給者異動送付entity = 受給者異動送付Dac.
                    selectAllByTwoKey(受給者訂正連絡票登録画面Div.get被保険者番号(),
                            受給者訂正連絡票登録画面Div.get異動年月日());
            if (受給者異動送付entity != null && 受給者異動送付entity.getRirekiNo() != 履歴番号) {
                result.set登録件数(1);
                result.setメッセージコード(new RString(UrErrorMessages.既に存在.getMessage().getCode()));
            } else {
                DbT3001JukyushaIdoRenrakuhyoEntity minRirekiNoの受給者異動送付
                        = 受給者異動送付Dac.selectMaxRirekiNoByMinIdoYMD(受給者訂正連絡票登録画面Div.get被保険者番号(),
                                受給者訂正連絡票登録画面Div.get異動年月日());
                get登録件数(受給者訂正連絡票登録画面Div, result, minRirekiNoの受給者異動送付);
            }
        }
        return result;
    }

    /**
     * 受給者異動送付テーブルにデータの追加処理を行う。
     *
     * @param 受給者訂正連絡票登録画面Div JukyushaIdoRenrakuhyo
     * @return int
     */
    @Transaction
    public int insert受給者異動送付(JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div) {
        if (!EntityDataState.Unchanged.equals(受給者訂正連絡票登録画面Div.toEntity().getState())) {
            受給者異動送付Dac.save(受給者訂正連絡票登録画面Div.toEntity());
            return 1;
        } else {
            return 0;
        }
    }

    private void get登録件数(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaTeiseiRenrakuhyoTorokuManagerResult result,
            DbT3001JukyushaIdoRenrakuhyoEntity minRirekiNoの受給者異動送付) {
        if (THREE.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())
                && ONE.equals(受給者訂正連絡票登録画面Div.get異動区分コード())
                && minRirekiNoの受給者異動送付 != null
                && (TWO.equals(minRirekiNoの受給者異動送付.getIdoKubunCode())
                || THREE.equals(minRirekiNoの受給者異動送付.getIdoKubunCode()))) {
            result.set登録件数(1);
            result.setメッセージコード(new RString(UrErrorMessages.実行不可.getMessage().getCode()));
        } else if (THREE.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())
                && THREE.equals(受給者訂正連絡票登録画面Div.get異動区分コード())
                && minRirekiNoの受給者異動送付 != null
                && ONE.equals(minRirekiNoの受給者異動送付.getIdoKubunCode())) {
            result.set登録件数(1);
            result.setメッセージコード(new RString(UrErrorMessages.実行不可.getMessage().getCode()));
        }
    }
}
