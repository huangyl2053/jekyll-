/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuKaijo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuTekiyo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuSoshitsuJiyuHihokennsha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KofuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳のModelです。
 *
 * @author n8178 城間篤人
 */
//このクラスは、他のスケルトンコード実装用のdummyです。
//現在定義されているメソッドは、ツールによって作成しなおした後に、
//改めて実装するようにしてください。
public class HihokenshaDaichoModel implements IHihokenshaDaicho {

    private final DbT1001HihokenshaDaichoEntity entity;

    /**
     * コンストラクタです。メンバのEntityを生成して初期化します。
     */
    public HihokenshaDaichoModel() {
        entity = new DbT1001HihokenshaDaichoEntity();
        //TODO #52997
        //entityが持つメンバに対して初期値を設定する処理を実装してください。
    }

    /**
     * コンストラクタです。引数からEntityを受け取ります。
     *
     * @param entity 被保険者台帳Entity
     */
    public HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * モデルの更新ステータスを返します。
     *
     * @return 更新ステータス
     */
    public EntityDataState getState() {
        //TODO #52997
        //EntityのgetState()を返却するようにしてください。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO #52997
    //Entityの更新stateを設定する処理を実装してください。
    public void setState(EntityDataState state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    //TODO #52997
    //以下のgetterは、get資格取得日()を参考に、それぞれのメソッドに対応する値をEntityからgetする形で実装してください。
    @Override
    public LasdecCode get市町村コード() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HihokenshaNo get被保険者番号() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public YMDHMS get処理日時() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ShikibetsuCode get識別コード() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ShoKisaiHokenshaNo get広住特措置元保険者番号() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LasdecCode get旧市町村コード() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get資格取得届出日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get資格喪失日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get資格喪失届出日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get資格変更日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get資格変更届出日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get住所地特例適用日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get住所地特例適用届出日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get住所地特例解除日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get住所地特例解除届出日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlexibleDate get年齢到達日() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get帳票交付履歴ID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuShutokuJiyuHihokensha get資格取得事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuSoshitsuJiyuHihokennsha get資格喪失事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ShikakuHihokenshaKubun get被保険者区分() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuHenkoJiyuHihokensha get資格変更事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuJutokuTekiyo get住所地特例適用事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuJutokuKaijo get住所地特例解除事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JushochiTokureishaKubun get住所地特例区分() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KoikinaiJushochitokureishaKubun get広域内住所地特例区分() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HihokenshashoSaikofuKubun get再交付区分() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KofuJiyu get再交付事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 資格取得日
     */
    public void set資格取得日(FlexibleDate 資格取得日) {
        entity.setShikakuShutokuYMD(資格取得日);
    }
    //TODO #52997
    //以下に、set資格取得日を参考に、Entityのメンバに対して値を設定するためのsetterを用意してください。
}
