/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity;

import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村情報 の項目定義クラスです。
 */
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonJoho implements IShichosonJoho {

    private ShichosonShikibetsuID shichosonShokibetsuID;
    private LasdecCode shichosonCode;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString kokuhorenKoikiShichosonNo;
    private RString shichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private RString yubinNo;
    private RString jusho;
    private RString telNo;
    private RString yusenChikuCode;
    private RString tyohyoTodoufukenHyojiUmu;
    private RString tyohyoGunHyojiUmu;
    private RString tyohyoShichosonHyojiUmu;
    private RString tyohyoJushoHenshuHouhou;
    private RString tyohyoKatagakiHyojiUmu;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private RString tokuchoBunpaishuyaku;
    private FlexibleDate ikoYMD;
    private FlexibleDate kanyuYMD;
    private FlexibleDate ridatsuYMD;
    private RString gappeiKyuShichosonKubun;
    private RString gappeiKyuShichosonHyojiUmu;
    private RString gappeiChiikiNo;
    private ShoKisaiHokenshaNo unyoHokenshaNo;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private RString unyoKeitaiKubun;

    @Override
    public ShichosonShikibetsuID get市町村識別ID() {
        return this.shichosonShokibetsuID;
    }

    @Override
    public LasdecCode get市町村コード() {
        return this.shichosonCode;
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return shoKisaiHokenshaNo;
    }

    @Override
    public RString get国保連広域内市町村番号() {
        return kokuhorenKoikiShichosonNo;
    }

    @Override
    public RString get市町村名() {
        return shichosonMeisho;
    }

    @Override
    public RString get都道府県名称() {
        return todofukenMeisho;
    }

    @Override
    public RString get郡名称() {
        return gunMeisho;
    }

    @Override
    public RString get郵便番号() {
        return yubinNo;
    }

    @Override
    public RString get住所() {
        return jusho;
    }

    @Override
    public RString get電話番号() {
        return telNo;
    }

    @Override
    public RString get最優先地区コード() {
        return yusenChikuCode;
    }

    @Override
    public RString get帳票用都道府県名称表示有無() {
        return tyohyoTodoufukenHyojiUmu;
    }

    @Override
    public RString get帳票用郡名称表示有無() {
        return tyohyoGunHyojiUmu;
    }

    @Override
    public RString get帳票用市町村名称表示有無() {
        return tyohyoShichosonHyojiUmu;
    }

    @Override
    public RString get帳票用住所編集方法() {
        return tyohyoJushoHenshuHouhou;
    }

    @Override
    public RString get帳票用方書表示有無() {
        return tyohyoKatagakiHyojiUmu;
    }

    @Override
    public RString get老人保健市町村番号() {
        return rojinhokenShichosonNo;
    }

    @Override
    public RString get老人保健受給者番号体系() {
        return rokenJukyushaNoTaikei;
    }

    @Override
    public RString get特徴分配集約() {
        return tokuchoBunpaishuyaku;
    }

    @Override
    public FlexibleDate get移行日() {
        return ikoYMD;
    }

    @Override
    public FlexibleDate get加入日() {
        return kanyuYMD;
    }

    @Override
    public FlexibleDate get離脱日() {
        return ridatsuYMD;
    }

    @Override
    public RString get合併旧市町村区分() {
        return gappeiKyuShichosonKubun;
    }

    @Override
    public RString get合併旧市町村表示有無() {
        return gappeiKyuShichosonHyojiUmu;
    }

    @Override
    public RString get合併情報地域番号() {
        return gappeiChiikiNo;
    }

    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return unyoHokenshaNo;
    }

    @Override
    public FlexibleDate get運用開始日() {
        return unyoKaishiYMD;
    }

    @Override
    public FlexibleDate get運用終了日() {
        return unyoShuryoYMD;
    }

    @Override
    public RString get運用形態区分() {
        return unyoKeitaiKubun;
    }
}
