package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBA-0190-010 houtianpeng
 */
public interface IShisetsuJohoCommonChildDiv extends ICommonChildDivBaseProperties {

    public abstract void initialize();

    public abstract RString getNyuryokuShisetsuKodo();

    public abstract RString getNyuryokuShisetsuMeisho();

    public abstract void setNyuryokuShisetsuKodo(RString nyuryokuShisetsucode);

    public abstract RString getDaichoShubetsu();

    public abstract void set台帳種別(RString key);

    public abstract RString get施設種類();

    public abstract void set施設種類(RString key);

    public abstract void setShisetsuMeisho(RString meisho);

    public abstract void get入所施設名称(JigyoshaNo 入所施設コード);

    public abstract void clear();

    public abstract void setサービス種類(RString サービス種類抽出区分, List<RString> サービス種類);
}
