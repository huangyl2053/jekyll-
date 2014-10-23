/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.model.IHihokensaDaicho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuKaijo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuTekiyo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuSoshitsuJiyuHihokennsha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KofuJiyu;

/**
 * 被保険者台帳を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaicho implements IHihokensaDaicho {

    private final HihokenshaDaichoModel model;

    /**
     * コンストラクタです。
     *
     * @param model HihokenshaDaichoModel
     */
    public HihokenshaDaicho(HihokenshaDaichoModel model) {
        requireNonNull(model, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("引数のmodel", getClass().getSimpleName()));
        this.model = model;
    }

    /**
     * {@link HihokenshaDaichoModel HihokenshaDaichoModel}へ変換します。
     *
     * @return
     * このオブジェクトが保持するHihokenshaDaichoModelと同じ値を持った、新しいHihokenshaDaichoModel
     */
    public HihokenshaDaichoModel toModel() {
        //TODO #52997
        //自身のメンバであるmodelの、getDbT1001HihokenshaDaichoEntity()を引数に
        //新規にHihokenshaDaichoModelを生成して返す実装をしてください。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LasdecCode get市町村コード() {
        return this.model.get市町村コード();
    }

    //TODO #52997
    //以下のメソッドを、メンバのmodelを使用する形で実装してください。
    //get市町村コード()を参考に、modelが持つ同名メソッドを返す形で実装をしてください。
    @Override
    public KaigoHihokenshaNo get被保険者番号() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public YMDHMS get処理日時() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ShikibetsuCode get識別コード() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ShoKisaiHokenshaNo get広住特措置元保険者番号() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LasdecCode get旧市町村コード() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get取得日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get取得届出日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get喪失日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get喪失届出日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get変更日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get変更届出日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get適用日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get適用届出日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get解除日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get解除届出日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlexibleDate get年齢到達日() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int get帳票交付履歴ID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public KaigoshikakuShutokuJiyuHihokensha get取得事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuSoshitsuJiyuHihokennsha get喪失事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuHenkoJiyuHihokensha get変更事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuJutokuTekiyo get適用事由() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoshikakuJutokuKaijo get解除事由() {
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

    @Override
    public ShikakuHihokenshaKubun get被保険者区分() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
