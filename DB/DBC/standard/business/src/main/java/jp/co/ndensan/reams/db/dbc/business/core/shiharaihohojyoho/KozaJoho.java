/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0715KozaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座情報を保持するクラスです。
 */
public class KozaJoho implements Serializable {

    private final UrT0715KozaEntity entity;

    /**
     * コンストラクタです。<br/>
     * 口座情報の新規作成時に使用します。
     *
     * @param 口座情報 口座テーブルのエンティティクラス
     */
    public KozaJoho(UrT0715KozaEntity 口座情報) {
        requireNonNull(口座情報, UrSystemErrorMessages.値がnull.getReplacedMessage("口座情報"));
        this.entity = 口座情報;
    }

    /**
     * 口座IDを返します。
     *
     * @return 口座ID
     */
    public long get口座ID() {
        return entity.getKozaId();
    }

    /**
     * 業務コードを返します。
     *
     * @return 業務コード
     */
    public GyomuCode get業務コード() {
        return entity.getGyomuCode();
    }

    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }

    /**
     * 科目コードを返します。
     *
     * @return 科目コード
     */
    public KamokuCode get科目コード() {
        return entity.getKamokuCode();
    }

    /**
     * 業務固有キーを返します。
     *
     * @return 業務固有キー
     */
    public RString get業務固有キー() {
        return entity.getGyomuKoyuKey();
    }

    /**
     * 用途区分を返します。
     *
     * @return 用途区分
     */
    public Code get用途区分() {
        return entity.getYotoKubun();
    }
}
